package efub.insta.handler;


import com.fasterxml.jackson.databind.ObjectMapper;
import efub.insta.dto.ChatMsgDto;
import efub.insta.dto.ChatRoomDto;
import efub.insta.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.HashMap;

@RequiredArgsConstructor
@Component
public class SocketHandler extends TextWebSocketHandler {

    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    HashMap<String, WebSocketSession> sessionMap = new HashMap<>(); //웹소켓 세션을 담아둘 맵

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        //메시지 발송
        String payload = message.getPayload(); //수신받은 메시지 payload에 저장
        ChatMsgDto chatMsgDto = objectMapper.readValue(payload, ChatMsgDto.class);
        ChatRoomDto chatRoomDto = chatService.findRoomById(chatMsgDto.getRoomNo());
        chatRoomDto.handleActions(session, chatMsgDto, chatService);

    }
}
