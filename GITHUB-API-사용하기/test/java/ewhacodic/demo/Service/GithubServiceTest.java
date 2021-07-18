package ewhacodic.demo.Service;

import ewhacodic.demo.dto.GithubInfoDto;
import ewhacodic.demo.service.GithubInfoService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GithubServiceTest {
    GithubInfoDto githubInfoDto;
    GithubInfoService githubInfoService;

    @BeforeEach
    public void beforeEach() {
        //githubInfoDto = new GithubInfoDto();
        githubInfoService = new GithubInfoService();
    }
    @Test
    public void 커밋카운트() throws Exception {
        //Given
        GithubInfoDto githubInfoDto = new GithubInfoDto();
        githubInfoDto.setUserName("ottl-seo");
        githubInfoDto.setRepoName("Algorithm");
        githubInfoDto.setStartDate("2021-07-01T00:00:00Z");
            //CurrentDate는 자동 생성

        //When
        Long commits = githubInfoService.CommitCount(githubInfoDto);

        //Then
        //AssertThat 꼭 써야하나 (아직 Repository 안만들어서 필요없는 상황)
        System.out.println(commits); //그냥 출력해서 확인해보기
    }
}
