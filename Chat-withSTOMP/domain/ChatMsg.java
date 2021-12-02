package efub.insta.domain;

import efub.insta.dto.ChatMsgDto;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ChatMsg {

    private ChatMsgDto.MsgType type; //메시지 타입

    @ManyToOne
    @JoinColumn(name = "chatroom")
    @Column(name = "chatroom_no")
    private String roomNo; //방번호

    @ManyToOne
    @JoinColumn(name = "user")
    @Column(name = "user_no")
    private String sender; //보낸 사람

    @Column(name = "message")
    private String content; //메시지 내용
}
