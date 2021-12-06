# gmail 인증번호 전송 연습
[CORS-삽질/](https://www.popit.kr/cors-preflight-%EC%9D%B8%EC%A6%9D-%EC%B2%98%EB%A6%AC-%EA%B4%80%EB%A0%A8-%EC%82%BD%EC%A7%88/)

[Spring-Boot-CORS-설정하기](https://dev-pengun.tistory.com/entry/Spring-Boot-CORS-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0)

---
## ✏ 오류 해결 일지

리액트와 연동중 **CORS** 오류가 났다.

우선, `@CrossOrigin("*")` 을 넣어줘도 반응이 없었기 때문에 뭔가 이전 코드의 문제일 것이라는 예감을 받았다. 해당 프로젝트에서 Spring security를 이용해 토큰으로 api에 접근할 수 있게 했었는데, 이들을 다 지우고 MailController 만 남긴 프로젝트를 만들었다.

### 오류 0. Controller에서 POST, GET을 받아올 수 없음

- 해결

```java
** 해결 전 **
@PostMapping("/CheckMail")

** 해결 후 **
@RequestMapping(value="/CheckMail", method = {RequestMethod.GET, RequestMethod.POST})
```

### 오류 1. 메일 라이브러리 관련 Exception

```java
There was an unexpected error (type=Internal Server Error, status=500).
Could not parse mail; nested exception is javax.mail.internet.AddressException: 
Local address contains control or whitespace in string ``EWHA CODIC''
org.springframework.mail.MailParseException: Could not parse mail; nested exception is javax.mail.internet.AddressException: Local address contains control or whitespace in string ``EWHA CODIC''
```

해결 → sender명에 공백을 없애준다

### 오류 2. 상태코드 500: No Message Available

명확한 설명 없이, 서버측의 오류라는 상태코드만 출력.

→ `@ResponseBody` 어노테이션 넣어줘도 그대로임.

---

//여기서, `@CrossOrigin("*")` 을 빼보았다

→ 바로 CORS 에러 다시 생김. 
이로써 전체 프로젝트에서 발생하던 CORS 문제는 스프링시큐리티 토큰 때문이었음이 분명해졌다.  ( /CheckMail 에 접근할 수조차 없어서)

→ 그건 어떻게 해결하지 .... spring security 알 수 없다

---

여러 시도를 해봄 → ResponseBody, RequestBody, ...

```java
package codic.ewhain.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
 
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RequiredArgsConstructor
@RestController
public class MailController {

    @CrossOrigin(origins = "*")
    @RequestMapping(value="/CheckMail", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> SendMail(@RequestBody String mail, HttpSession session) {

        Map<String, Object> map = new HashMap<>();
        Random random = new Random();
        JavaMailSender javaMailSender = new JavaMailSenderImpl();
        //MailUtils mailUtils = new MailUtils(javaMailSender); //내가 추가한 코드
        String key = "";
        //String mail = id+"@ewhain.net";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mail); // 스크립트에서 보낸 메일을 받을 사용자 이메일 주소
        // 입력 키를 위한 코드
        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(25) + 65; // A~Z까지 랜덤 알파벳 생성
            key += (char) index;
        }
        int numIndex = random.nextInt(8999) + 1000; // 4자리 정수를 생성
        key += numIndex;
        message.setSubject("이화코딕 회원가입을 위한 인증번호 전송");
        message.setText("인증 번호 : " + key);
        message.setFrom("CODIC");
        javaMailSender.send(message);
        map.put("key", key);
        return map;
    }
}
```

한 번 이렇게 바꿔보았다.

```java
@CrossOrigin(origins = "*")
    @RequestMapping(value="/CheckMail/{id}", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> SendMail(@PathVariable("id") String id, HttpSession session) throws Exception {

        Map<String, Object> map = new HashMap<>();
        Random random = new Random();
        JavaMailSender javaMailSender = new JavaMailSenderImpl();
        //MailUtils mailUtils = new MailUtils(javaMailSender); //내가 추가한 코드
        String key = "";
        String mail = id+"@ewhain.net";
```

그랬더니,

```java
There was an unexpected error (type=Internal Server Error, status=500).
Mail server connection failed; nested exception is 
com.sun.mail.util.MailConnectException: Couldn't connect to host, port: 
localhost, 25; timeout -1; nested exception is: java.net.ConnectException: 
Connection refused: connect. Failed messages: com.sun.mail.util.MailConnectException: 
Couldn't connect to host, port: localhost, 25; timeout -1; nested exception is: 
java.net.ConnectException: Connection refused: connect
org.springframework.mail.MailSendException: Mail server connection failed; 
nested exception is com.sun.mail.util.MailConnectException: 
Couldn't connect to host, port: localhost, 25; timeout -1;
```

---

# 방법을 바꿨다.

|— MailConfig
|— MailController
|— MailService
|— Dto
    |— MailDto
    |— MailCodeDto

### Controller 코드

```java
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/email", method = {RequestMethod.GET, RequestMethod.POST})
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/send")
    public boolean sendEmail(@RequestBody EmailDto email) throws Exception {
        try{
            emailService.sendSimpleMessage(email.getEmail());
            return true;
        } catch (Exception e){
            return false;
        }
        //return ResponseEntity.ok(ResponseDto.of(HttpStatus.OK, EMAIL_SEND_SUCCESS));

    }
}
```

### 결과

→ 그래도 이제 오류가 아니라 `false` 라는 값이 뜬다.

```java
org.springframework.mail.MailSendException: 
Failed messages: javax.mail.internet.AddressException: 
Local address contains control or whitespace in string ``������ ����''; 
message exception details (1) are:
Failed message 1:
```

→ 뭔가 json값이 전달은 됐는데 인코딩이 잘못된 듯 하다. 
그리고 Email 특성상 @문자가 들어가서인지 이상하게 뜨는듯.

→ "@ewhain.net"은 String 처리해서 뒤에 붙여주고, 아이디만 받아오기로 한다.

값이 잘 안 들어오는 것 같으니, encode 해주자

그래도 인증번호 생성까지는 잘 동작한다 ! (전송이 안 될 뿐) 

((메일 주소가 잘못되어서이니 얼른 고쳐보자))

---

MailSendException 을 해결하는 방법 중 하나로, [email.properties](http://email.properties) 에 다음과 같은 설정을 추가해줬다.

```java
##지메일 SMTP를 사용하기 위해 설정
spring.mail.host=smtp.gmail.com

##465 포트를 사용하기 위해 설정
mail.smtp.ssl.enable=true
```

---

## @RequestBody → JSON을 String으로 변경

내가 진짜 엉뚱한 곳에서 헤매고 있었다는 걸 깨달았다.

"보내는 사람 주소"에 주소(__@____ 형태) 를 넣지 않고 저 문자 그대로 돌려버려서, 유효한 주소가 아니라는 거였다. (허무...)


## 🎉 성공적인 결과

너무 감격스러워서 캡쳐

![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7816cb89-1fdf-4947-aca7-c5631c48197f/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7816cb89-1fdf-4947-aca7-c5631c48197f/Untitled.png)

### references
https://gist.github.com/ihoneymon/56dd964336322eea04dc    
https://offbyone.tistory.com/167   
https://victorydntmd.tistory.com/342   
https://moonong.tistory.com/45   
https://compogetters.tistory.com/54?category=854053
