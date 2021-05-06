package ottl.hijava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ottl.hijava.repository.JdbcTemplateMemberRepository;
import ottl.hijava.repository.MemberRepository;
import ottl.hijava.repository.MemoryMemberRepository;

import javax.sql.DataSource;


@Configuration
public class SpringConfig {
    private DataSource dataSource; //변수 정의

    @Autowired
    public SpringConfig(DataSource dataSource){ //생성자 --> 외부변수를 여기서 사용가능하게 함
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource); //이 부분만 바꿔주면 OK!
    }
}
