package ottl.hijava.repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import ottl.hijava.domain.Post;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JdbcTemplatePostRepository implements PostRepository { // Alt+Enter로 implement해서 메서드 불러옴
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplatePostRepository(DataSource dataSource){ //생성자
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override /* 여기 좀만 더 고치기 */
    public Post save(Post post) {
        //return null; // 초반에 메서드 정의하느라 썼던 의미없던 코드 지우고

        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
        jdbcInsert.withTableName("post").usingGeneratedKeyColumns("id");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("title", post.getTitle());

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        post.setId(key.longValue());
        return post;
    }

    @Override
    public Optional<Post> findById(Long id) {
        List<Post> result = jdbcTemplate.query("SELECT * FROM MEMBER WHERE ID = ?", postRowMapper(), id);
        return result.stream().findAny(); // ?
    }

    @Override
    public Optional<Post> findByTitle(String name) {
        List<Post> result = jdbcTemplate.query("SELECT * FROM MEMBER WHERE NAME = ?", postRowMapper(), name);
        return result.stream().findAny();
    }

    @Override
    public List<Post> findAll() {
        return jdbcTemplate.query("SELECT * FROM MEMBER", postRowMapper());
    }

    private RowMapper<Post> postRowMapper() {
        /* DB에서 SELECT 해서 가져온 결과값을 멤버필드에 매핑하기 위해서 필요 */
        return (rs, rowNum) -> {
            Post post = new Post();
            post.setId(rs.getLong("id"));
            post.setTitle(rs.getString("name"));
            return post;
        };
    }
}
