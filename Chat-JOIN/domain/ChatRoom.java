package efub.insta.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "chat_room")
public class ChatRoom {
    // chatMsg랑 chatRoom JOIN
    // chatMsg랑 ChatUser JOIN
    @Id @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "room_no")
    private int roomNo;

//    @Column(name = "room_id") //그냥 없애줌, 컬럼 room_no만 존재
//    private String name;

    @OneToMany(mappedBy = "message", cascade = CascadeType.ALL)
    private List<ChatMessage> messages = new ArrayList<>();

    @Builder
    public ChatRoom(int roomNo){
        this.roomNo = roomNo;
    }
}
