package ottl.hijava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ottl.hijava.repository.JdbcTemplatePostRepository;
import ottl.hijava.repository.PostRepository;

import javax.sql.DataSource;


@Configuration
public class SpringConfig {

    private DataSource dataSource; //변수 정의

    @Autowired
    public SpringConfig(DataSource dataSource){ //생성자 --> 외부변수를 여기서 사용가능하게 함
        this.dataSource = dataSource;
    }
/*  // JPA 사용할 경우
    private EntityManager em;
    @Autowired
    public SpringConfig(EntityManager em){
        this.em = em;
    }
*/
    @Bean
    public PostService postService() {
        return new PostService(postRepository());
    }
    @Bean
    public PostRepository postRepository() {
        //return new MemoryMemberRepository();
        return new JdbcTemplatePostRepository(dataSource); //이 부분만 바꿔주면 OK!
        //return new JpaMemberRepository(em);
    }
}
