package efub.insta.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    List<Like> findByPostNoAndDeletedFlagFalse(Long postNo);
    Like findByPostNoAndUser(Long postNo, User user);
}
