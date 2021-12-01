package efub.insta.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Optional;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "chat_message")
public class ChatMessage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_no")
    private int id;

    @Column(name = "message")
    private String message; //메시지 내용

    @ManyToOne
    @JoinColumn(name = "room_no")
    //@Column(name = "chatroom_no")
    private ChatRoom roomNo; //방번호

    //@JoinColumn(name = "user_no")  //실제 user와 연결되는 것이 아니라, 입력하고 들어가는 건데 해둬도 될지,??
    //@ManyToOne
    @Column(name = "user_no")
    private String sender; //보낸 사람

    //@Column(name = "time")
    private LocalDateTime time;

    @Builder
    public ChatMessage(String message, LocalDateTime time, ChatRoom roomNo, String sender){
        this.message = message;
        this.time = time;
        this.roomNo = roomNo;
        this.sender = sender;
    }
}
