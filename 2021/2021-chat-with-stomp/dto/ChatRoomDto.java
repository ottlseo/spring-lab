package efub.insta.dto;

import efub.insta.domain.ChatRoom;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter @Setter
public class ChatRoomDto {
    private String roomNo;
    private String name;

    public static ChatRoomDto create(String name){
        ChatRoomDto chatRoom = new ChatRoomDto();
        chatRoom.setRoomNo(UUID.randomUUID().toString());
        chatRoom.setName(name);
        return chatRoom;
    }
}
