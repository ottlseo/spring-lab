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

    //private final GithubInfoRepository githubInfoRepository = new GithubInfoRepository();

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
                commits += Integer.parseInt(String.valueOf(each.get(2))); // number형 Int로 바꾸는 방법-> String을 거친다
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return commits; // 5. 커밋 수 리턴
    }


}
