package efub.insta.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRoomJoinRepository extends JpaRepository<ChatRoomJoin, Long> {
    public List<ChatRoomJoin> findByUser(String user);

    public List<ChatRoomJoin> findByChatRoom(ChatRoom chatRoom);
}
