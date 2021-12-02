package efub.insta.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "chatroom")
public class ChatRoom {
    // chatMsg랑 chatRoom JOIN
    // chatMsg랑 ChatUser JOIN
    @Id
    @Column(name = "room_no")
    private String roomNo;

    @Column(name = "room_name")
    private String name;

    @Builder
    public ChatRoom(String roomNo, String name){
        this.roomNo = roomNo;
        this.name = name;
    }
}
