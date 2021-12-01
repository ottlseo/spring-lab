package efub.insta.domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoom, Integer>{
    public Optional<ChatRoom> findById(Long id);
}
