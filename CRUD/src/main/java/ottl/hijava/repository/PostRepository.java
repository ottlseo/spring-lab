package ottl.hijava.repository;

import ottl.hijava.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    /* interface 니까 상속받는 클래스에 대한 정의 포함해야함 */

    Post save(Post member);
    Optional<Post> findById(Long id);
    Optional<Post> findByTitle(String title);
    List<Post> findAll();
}
