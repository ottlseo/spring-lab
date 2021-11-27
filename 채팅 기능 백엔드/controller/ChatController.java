package efub.insta.controller;

import efub.insta.domain.ChatRoom;
import efub.insta.dto.ChatRoomDto;
import efub.insta.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/chat")
public class ChatController {
    //@Autowired
    private final ChatService chatService;

    @PostMapping
    public ChatRoom createRoom(@RequestParam String name){
        return chatService.createRoom(name);
    }
    @GetMapping("/roomList")
    public List<ChatRoomDto> findAllRoom(){
        return chatService.getRoomList();
    }

}
