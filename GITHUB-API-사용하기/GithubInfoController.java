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
            //CurrentDate는 자동 생성

        Long commits = githubInfoService.CommitCount(githubInfoDto);
        return commits;
    }
}
