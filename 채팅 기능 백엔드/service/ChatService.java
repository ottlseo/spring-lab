package efub.insta.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import efub.insta.domain.ChatRoom;
import efub.insta.domain.ChatRoomRepository;
import efub.insta.domain.PostRepository;
import efub.insta.dto.ChatRoomDto;
import efub.insta.dto.PostDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ChatService {

    private final ObjectMapper objectMapper;
    // chatRooms map은 생성된 모든 채팅방의 정보를 모아둔 구조체
    // (다음에 DB로 바꿀 부분)
    //private Map<String, ChatRoomDto> chatRooms;
    private final ChatRoomRepository chatRoomRepository;

    /*
    @PostConstruct
    private void init() {
        chatRooms = new LinkedHashMap<>();
    }

     */

    @Transactional
    public List<ChatRoomDto> getRoomList() {
        return chatRoomRepository.findAll().stream().map(chatRoom -> new ChatRoomDto(chatRoom)).collect(Collectors.toList());
    }
    public ChatRoomDto findRoomById(String roomId) {
        //return chatRooms.get(roomId);
        return (ChatRoomDto) chatRoomRepository.findById(roomId).stream();
    }

    public ChatRoom createRoom(String name) {
        String randomId = UUID.randomUUID().toString();
        ChatRoom chatRoom = ChatRoom.builder()
                .roomNo(randomId) //랜덤 번호로 방 번호 생성
                .name(name)
                .build();
        chatRoomRepository.save(chatRoom);
        return chatRoom;
    }

    public <T> void sendMessage(WebSocketSession session, T message) {
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}