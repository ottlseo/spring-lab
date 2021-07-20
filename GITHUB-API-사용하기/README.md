# github api로 한 주 커밋 수 가져오기

## 🏁 API 설명

**[매일 시간당 커밋 수 가져 오기](https://docs.github.com/en/rest/reference/repos#get-the-hourly-commit-count-for-each-day)**   
[GET] /repos/{owner}/{repo}/stats/punch_card   

```java
https://api.github.com/repos/EWHACODIC/back-end/stats/punch_card
?since=2021-07-01T00:00:00Z&until=2021-07-08T23:59:59Z&author=ottl-seo
```

(아래 결과) 각 배열에는 일 번호, 시간 번호 및 커밋 수가 포함됩니다.   
- 0-6: Sunday - Saturday
- 0-23: Hour of day
- Number of commits

```java
https://api.github.com/repos/EWHACODIC/back-end/stats/punch_card

https://api.github.com/repos/EWHACODIC/back-end/stats/punch_card
?since=2021-07-01T00:00:00Z&until=2021-07-08T23:59:59Z&author=ottl-seo
```


```java
[
  [
    0,
    0,
    0
  ],
  [
    0,
    1,
    0
  ],
  [
    0,
    2,
    0
  ],
  [
    0,
    3,
    0
  ], 
  
  ... 
  
  [
    6,
    20,
    0
  ],
  [
    6,
    21,
    0
  ],
  [
    6,
    22,
    0
  ],
  [
    6,
    23,
    2
  ]
]
```

---

## 🏁 MVC 구성

- **`Controller`** → **GithubInfoController.java**

    : URI 매핑하고, (*/api/commit_count*) 
    service에서 정의한 함수 사용하기

- **`DTO`** → **GithubInfoDto.java**

    : 객체가 가질 내용 포함하기

- **`Service`** → **GithubInfoService.java**

    : **API 여기서 사용!**

    API로 값 가져오고, 한 주 커밋 수 전부 더해서 리턴하는 함수 정의(*CommitCount*)

---

## 🏁 오류 해결 일지

### Dto

```java
package ewhacodic.demo.dto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class GithubInfoDto {
    private String userName;
    private String repoName;
    private String startDate; // 이건 어떻게 할지 논의 필요 -> 현재로부터 -7일?
    private String currentDate; // //현재 날짜와 시간 정보 (until= 에 사용 예정)
```

### Service

[로직]

1. api.github.com/ Url에서 json으로 된 결과값 받아오기
2. json 읽기 (buffer로)
3. jsonArray로 받아오기 *(원래 파싱 했었는데, 삭제하고 그냥 Array로 받아옴)*
4. 배열을 반복하며 덧셈 → 총 커밋 수 리턴

```java
package ewhacodic.demo.service;
import ewhacodic.demo.dto.GithubInfoDto;

import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
//import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GithubInfoService {

    public long CommitCount(GithubInfoDto githubInfoDto){ //커밋 수 계산하는 함수-> 여기서 정의하고 Controller에서 호출해줄것
        long commits=0;
        String result="";
/*
        // 0. 현재 시간 (LocalDateTime.now() 계산)
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-ddThh:mm:ssZ");
        String currentDate = now.format(dateTimeFormatter);
        githubInfoDto.setCurrentDate(currentDate);

        // + 시작 날짜 매번 바꿔주기(일주일 단위로) -> how? CurrentTime에서 일주일 빼주기???
*/
        try {
            // 1. url에서 json 받아오기
            URL url = new URL("https://api.github.com/repos/" + githubInfoDto.getUserName()
                    + "/" + githubInfoDto.getRepoName() + "/stats/punch_card?since="
                    + githubInfoDto.getStartDate() + "&until=" + githubInfoDto.getCurrentDate());

            // 2. json을 읽어오기
            BufferedReader bf;
            bf = new BufferedReader(new InputStreamReader(url.openStream())); //받아오기
            String line = "";
            while ((line = bf.readLine()) != null) { //하나의 문자열로 변환
                result = result.concat(line);
            }

            // 3. 프로젝트 내에 jsonArray로 받아오기 (파싱)
            //JSONParser jsonParser = new JSONParser();
            //JSONArray jsonArray = (JSONArray) jsonParser.parse(result);
            JSONArray jsonArray = new JSONArray(result); //이렇게?

            // 4. 배열을 반복하며, [i][2] 정보를 모두 더하기 (총 커밋 수)
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONArray each = jsonArray.getJSONArray(i);
                commits += (long) each.get(2);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return commits; // 5. 커밋 수 리턴
    }

}
```

### Controller

```java
package ewhacodic.demo.controller;
import ewhacodic.demo.dto.GithubInfoDto;
import ewhacodic.demo.service.GithubInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class GithubInfoController {
    private final GithubInfoService githubInfoService;

    //테스트용
    @GetMapping(value = "/api/commit_count_test")
    public long commit_count_test(GithubInfoDto githubInfoDto) {

        //임의로 상황 설정해줌
        githubInfoDto.setUserName("ottl-seo");
        githubInfoDto.setRepoName("Algorithm");
        githubInfoDto.setStartDate("2021-07-01T00:00:00Z");
        githubInfoDto.setCurrentDate("2021-07-20T00:00:00Z");

        Long commits = githubInfoService.CommitCount(githubInfoDto);
        return commits;
    }
}
```

---

### 오류 1 : `java.lang.Long cannot be cast to java.lang.Integer`

→ number 형(Long)을 바로 int로 바꿔주려고 하기 때문

```java
/* 문제가 되는 부분 (Service) */
commits += (long) each.get(2);

/* 해결 */
// number형 Int로 바꾸는 방법-> String을 거친다
commits += Integer.parseInt(String.valueOf(each.get(2))); 
```

- reference

### 오류 2 : `Unknown return value type: java.lang.Long`

→ 이 오류는 생각보다 흔한 오류이다.

Long 타입이 문제인 줄 알고 계속 헤맸는데, Integer 타입을 사용하는 코드에서도 계속 이런 오류가 자주 나곤 한다.

- 해결 방법

```java
@RequestMapping(value = "/api/commit_count_test", method = RequestMethod.GET)
@ResponseBody
public long commit_count_test(GithubInfoDto githubInfoDto) { ... }
```

컨트롤러에서 **GetMapping** 방식 대신,   
**@RequestMapping**으로 변경한 후, **@ResponseBody** 어노테이션을 추가해주면 된다.

## ⇒ 성공!!! 😍

![image](https://user-images.githubusercontent.com/61778930/126288363-67a46026-f016-4a62-abf5-e3474e5bf422.png)

++ (int) ↔ (long) 형변환은 자동으로 된다. 알아두자

---

### 이제 해야 할 일

- [ ]  `LocalDateTime.now()` 활용하여 현재 시간까지의 커밋 수 가져오도록 **Service** 앞부분 수정 (*Easy*)
(지금은 *startDate*, *currentDate* 모두 임의로 넣어줬음)

- [ ]  **Repository** 만들어서, 커밋 수를 유저 번호와 함께 DB에 저장하도록 (*Hard*)
- [ ]  **Controller**도 user 정보에 맞게 URI 수정 (*Easy*?)

```java
@getMapping(/api/commits/{userName})
public long commitCount(@PathVariable("userName") String userName){
		githubInfoService.commitCount(userName); // 또는 userDto를 인자로 ? 

		// ...
}
```

- [ ]  DB 조회하여 랭킹 계산하는 **Service** 만들기 (*Hard*)


---

## OAuth2

→ 구글 아이디로 로그인, 깃허브 아이디로 로그인 등

(토큰을 이용해서 로그인 정보 저장해주는 것)

### ⇒ 우리는 구현할 필요 없다고 생각됨

https://github.com/cheese10yun/springboot-oauth2

