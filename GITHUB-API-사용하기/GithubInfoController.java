package ewhacodic.demo.controller;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import ewhacodic.demo.dto.GithubInfoDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.fasterxml.jackson.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;

import java.util.List;

public class GithubInfoController {
    // 클라이언트에 url 매핑이 되어야 하고
    @RequestMapping(value = "/url", method = RequestMethod.POST, produces = "application/json; charset=utf8")

    // 구글의 json paser 라이브러리
    Gson gson = new Gson();

    // jsonPaserPser 클래스 객체를 만들고 해당 객체에
    JsonParser jparser = new JsonParser();

    // param의 id 오브젝트 -> 문자열 파싱 -> jsonElement 파싱
    JsonElement elementId = jparser.parse(param.get("id").toString());
    // JsonElement -> List<String>으로 파싱
    List<String> idList = gson.fromJson(elementId, (new TypeToken<List<String>>() {  }).getType());
}

public GithubInfoDto test(){
       /* GithubInfoDto test = new GithubInfoDto(5);
        return  test;
        ObjectMapper objectMapper =new ObjectMapper();

        String url ="https://api.github.com/repos/ejhee1/FEF/stats/punch_card
        ?since=2021-02-09T00:00:00Z&until=2021-02-10T23:59:59Z?author=ejhee1";

        GithubInfoDto t = objectMapper.readValue(url, GithubInfoDto.class);
*/
        }