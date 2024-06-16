package efub.insta.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMsgDto {
    public enum MsgType { //메시지 타입: 입장, 채팅
        ENTER,
        TALK
    }
    private MsgType type; //메시지 타입
    private String roomNo; //방번호
    private String sender; //보낸 사람
    private String content; //메시지 내용
}
