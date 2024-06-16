package efub.insta.repo;

import efub.insta.domain.ChatRoom;
import efub.insta.dto.ChatRoomDto;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class ChatRoomRepository {
    private Map<String, ChatRoomDto> chatRoomMap; //이후에 DB랑 연결되게 바꾸기

    @PostConstruct
    private void init(){
        chatRoomMap = new LinkedHashMap<>();
    }
    public List<ChatRoomDto> findAllRoom(){
        List chatRooms = new ArrayList<>(chatRoomMap.values());
        Collections.reverse(chatRooms);
        return chatRooms;
    }
    public ChatRoomDto findRoomById(String id){
        return chatRoomMap.get(id);
    }
    public ChatRoomDto createChatRoom(String name){
        ChatRoomDto chatRoomDto = ChatRoomDto.create(name);
        chatRoomMap.put(chatRoomDto.getRoomNo(), chatRoomDto);
        return chatRoomDto;
    }
}
