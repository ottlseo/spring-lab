package efub.insta.controller;

import efub.insta.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")  //@RequestMapping("/chat")
public class ChatMessageController {
    //@Autowired
    private final ChatMessageService chatMessageService;
    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat/send")  // /app이후 url만 MessageMapping으로 요청받고 이후 각자 변경 가능
    public void sendMsg(ChatMessageForm message) throws Exception {
        String receiver = message.getReceiver();
        chatMessageService.save(message);
        simpMessagingTemplate.convertAndSend("/topic/" + receiver,message);
    }
}
