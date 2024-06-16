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
                            //LocalDateTime currentDateTime = LocalDateTime.now();

    /* //시간 데이터 형식 포맷하는 방법 (형식: 2021-07-17T23:59:59Z)
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-ddThh:mm:ssZ");
    String nowString = now.format(dateTimeFormatter);
     */
}
