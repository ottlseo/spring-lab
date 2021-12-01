package efub.insta.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class ChatRoomJoin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne
    //@JoinColumn(name = "user_no", nullable = false)
    @Column(name = "user_id")
    private String user;

    @ManyToOne
    @JoinColumn(name = "room_no", nullable = false)
    private ChatRoom chatRoom;

    @Builder
    public ChatRoomJoin(String user, ChatRoom chatRoom){
        this.user=user;
        this.chatRoom=chatRoom;
    }
}