package ottl.crud.dao;

import org.springframework.stereotype.Repository;
import ottl.crud.domain.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {  // 데이터 관리하는 곳. 데이터 다루는 함수를 정의하는 곳
    public static List<User> users;

    static{
        users = new ArrayList<>(); // DB연결은 아직 X, 임시 리스트로~
        users.add(new User(1, "user1", "dotsi", "1234"));
        users.add(new User(2, "user2", "dotsi2", "1234"));
        users.add(new User(3, "user3", "dotsi3", "1234"));
        users.add(new User(4, "user4", "dotsi4", "1234"));
    }
    public List<User> getAllUsers(){
        return users;
    }
    public User getUserByUserId(String userId){
        return users
                .stream()
                .filter(user -> user.getUserId().equals(userId))
                .findAny()
                .orElse(new User(-1, "", "", ""));
    }
    public User insertUser(User user){
        users.add(user); //user를 넣어주면 리스트에 추가
        return user;
    }
    public void updateUser(String userId, User user){
        users.stream()
                .filter(curUser -> curUser.getUserId().equals(userId))
                .findAny()
                .orElse(new User(-1, "", "", ""))
                .setUserName(user.getUserName());  // ??
    }
    public void deleteUser(String userId){
        users.removeIf(user -> user.getUserId().equals(userId));
    }
}
