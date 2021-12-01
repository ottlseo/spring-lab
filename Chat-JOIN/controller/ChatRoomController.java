package efub.insta.controller;

import efub.insta.domain.ChatMessage;
import efub.insta.domain.ChatRoom;
import efub.insta.domain.ChatRoomJoin;
import efub.insta.service.ChatRoomJoinService;
import efub.insta.service.ChatRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@RestController
@RequiredArgsConstructor
public class ChatRoomController {

    private final ChatRoomJoinService chatRoomJoinService;
    private final ChatRoomService chatRoomService;

    @PostMapping("/chat/newChat")
    public int newChat(@RequestParam("receiver") String user1, @RequestParam("sender") String user2){
        int chatRoomId = chatRoomJoinService.newRoom(user1,user2);
        return chatRoomId; //redirect에서 변경
    }
/*
    @RequestMapping("/personalChat/{chatRoomId}")
    public String goChat(@PathVariable("chatRoomId") int chatRoomId, String user){
        Optional<ChatRoom> opt = chatRoomService.findById(chatRoomId); //채팅방 찾기
        ChatRoom chatRoom = opt.get();
        List<ChatMessage> messages = chatRoom.getMessages(); //메시지 가져오기
        Collections.sort(messages, (t1, t2) -> {
            if(t1.getId() > t2.getId()) return -1;
            else return 1;
        });

        ChatMessageForm messageForm = new ChatMessageForm();
        messageForm.setReceiver(user);

        List<ChatRoomJoin> list = chatRoomJoinService.findByChatRoom(chatRoom);
        //model.addAttribute( "messages",messages);

        model.addAttribute("chatRoomId",chatRoomId);
        int cnt = 0;
        for(ChatRoomJoin join : list){
            if(join.getUser().equals(user) == false){
                model.addAttribute("receiver",join.getUser());
                ++cnt;
            }
        }
        return "chat/chatRoom";
    }

 */
}