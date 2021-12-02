package efub.insta.controller;

import efub.insta.domain.ChatRoom;
import efub.insta.dto.ChatMsgDto;
import efub.insta.dto.ChatRoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class ChatController {

    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/message")
    public void message(ChatMsgDto message) {
        if (ChatMsgDto.MsgType.ENTER.equals(message.getType()))
            message.setContent(message.getSender() + "님이 입장하셨습니다.");
        messagingTemplate.convertAndSend("/sub/chat/room/" + message.getRoomNo(), message);
    }
}