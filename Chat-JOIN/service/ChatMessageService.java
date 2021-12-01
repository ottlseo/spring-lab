package efub.insta.service;

import efub.insta.controller.ChatMessageForm;
import efub.insta.domain.ChatMessage;
import efub.insta.domain.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;
    private final ChatRoomService chatRoomService;
    @Transactional
    public void save(ChatMessageForm message) {
        ChatMessage chatMessage = new ChatMessage(message.getMessage(), LocalDateTime.now(), chatRoomService.findById(message.getChatRoomId()).get(), message.getSender());
        chatMessageRepository.save(chatMessage);
    }
}