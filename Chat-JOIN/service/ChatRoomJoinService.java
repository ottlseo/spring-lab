package efub.insta.service;

import efub.insta.domain.ChatRoom;
import efub.insta.domain.ChatRoomJoin;
import efub.insta.domain.ChatRoomJoinRepository;
import efub.insta.domain.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ChatRoomJoinService {
    private final ChatRoomJoinRepository chatRoomJoinRepository;
    private final ChatRoomRepository chatRoomRepository;
    //private final UsersService usersService;
    @Transactional(readOnly = true)
    public List<ChatRoomJoin> findByUser(String user) {
        return chatRoomJoinRepository.findByUser(user);
    }

    @Transactional(readOnly = true)
    public int check(String user1,String user2){
        //Users userFirst = usersService.findByName(user1);
        List<ChatRoomJoin> listFirst = chatRoomJoinRepository.findByUser(user1);
        Set<ChatRoom> setFirst = new HashSet<>(); //채팅방
        for(ChatRoomJoin chatRoomJoin : listFirst){
            setFirst.add(chatRoomJoin.getChatRoom());
        }
        List<ChatRoomJoin> listSecond = chatRoomJoinRepository.findByUser(user2);
        for(ChatRoomJoin chatRoomJoin : listSecond){
            if(setFirst.contains(chatRoomJoin.getChatRoom())){
                return chatRoomJoin.getChatRoom().getRoomNo();
            }
        }
        return 0;
    }
    @Transactional
    public int newRoom(String user1, String user2) {
        int ret = check(user1,user2);
        if(ret != 0){
            //이미 존재하는 방이면 해당 방 번호 리턴
            return ret;
        }
        ChatRoom chatRoom = new ChatRoom();
        ChatRoom newChatRoom = chatRoomRepository.save(chatRoom);
        if(user1.equals(user2)){
            //나 자신과의 채팅은 한명만 존재
            createRoom(user1,newChatRoom);
        }
        else{
            //두명 다 입장
            createRoom(user1,newChatRoom);
            createRoom(user2,newChatRoom);
        }
        return newChatRoom.getRoomNo();
    }
    @Transactional
    public void createRoom(String user, ChatRoom chatRoom){
        ChatRoomJoin chatRoomJoin = new ChatRoomJoin(user,chatRoom);
        chatRoomJoinRepository.save(chatRoomJoin);
    }
    @Transactional(readOnly = true)
    public List<ChatRoomJoin> findByChatRoom(ChatRoom chatRoom) {
        return chatRoomJoinRepository.findByChatRoom(chatRoom);
    }
    @Transactional
    public void delete(ChatRoomJoin chatRoomJoin) {
        chatRoomJoinRepository.delete(chatRoomJoin);
    }

    public String findAnotherUser(ChatRoom chatRoom, String name) {
        List<ChatRoomJoin> chatRoomJoins = findByChatRoom(chatRoom);
        for(ChatRoomJoin chatRoomJoin : chatRoomJoins){
            if(name.equals(chatRoomJoin.getUser()) == false){
                return chatRoomJoin.getUser();
            }
        }
        return name;
    }
}