package efub.insta.service;
import efub.insta.controller.ChatRoomForm;
import efub.insta.domain.ChatMessage;
import efub.insta.domain.ChatRoom;
import efub.insta.domain.ChatRoomJoin;
import efub.insta.domain.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ChatRoomService {
    private final ChatRoomRepository chatRoomRepository;
    private final ChatRoomJoinService chatRoomJoinService;

    @Transactional(readOnly = true)
    public Optional<ChatRoom> findById(int id) {
        return chatRoomRepository.findById(id);
    }

    public List<ChatRoomForm> setting(List<ChatRoomJoin> chatRoomJoins, String user) {
        List<ChatRoomForm> chatRooms = new ArrayList<>();
        for(ChatRoomJoin tmp : chatRoomJoins){
            ChatRoomForm chatRoomForm = new ChatRoomForm();
            ChatRoom chatRoom = tmp.getChatRoom();
            chatRoomForm.setId(chatRoom.getRoomNo());
            if(chatRoom.getMessages().size() != 0) {
                Collections.sort(chatRoom.getMessages(), new Comparator<ChatMessage>() {
                    @Override
                    public int compare(ChatMessage c1, ChatMessage c2) {
                        if(c1.getTime().isAfter(c2.getTime())){
                            return -1;
                        }
                        else{
                            return 1;
                        }
                    }
                });
                ChatMessage lastMessage = chatRoom.getMessages().get(0);
                chatRoomForm.makeChatRoomForm(lastMessage.getMessage(),chatRoomJoinService.findAnotherUser(chatRoom, user),lastMessage.getTime());
                chatRooms.add(chatRoomForm);
            }
            else{
                chatRoomJoinService.delete(tmp);
            }
        }
        Collections.sort(chatRooms, new Comparator<ChatRoomForm>() {
            @Override
            public int compare(ChatRoomForm c1, ChatRoomForm c2) {
                if(c1.getTime().isAfter(c2.getTime())){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        });
        return chatRooms;
    }
}