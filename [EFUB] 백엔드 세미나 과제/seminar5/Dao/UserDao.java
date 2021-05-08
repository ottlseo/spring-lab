package yoonseo.seminar5.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yoonseo.seminar5.Model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    public UserDao(){} //의존성 생성자에 주입하기 위해 생성자 만들기

    public static List<yoonseo.seminar5.Model.User> users; //user 리스트인 users 생성

    static{
        users= new ArrayList<>();
        users.add(new yoonseo.seminar5.Model.User(1, "testName1", "testId1", "1234"));
        users.add(new yoonseo.seminar5.Model.User(2, "testName2", "testId2", "1234"));
        users.add(new yoonseo.seminar5.Model.User(3, "testName3", "testId3", "1234"));
        users.add(new yoonseo.seminar5.Model.User(4, "testName4", "testId4", "1234"));
        users.add(new yoonseo.seminar5.Model.User(5, "testName5", "testId5", "1234"));
    }
    // select all user
    public List<yoonseo.seminar5.Model.User> getAllUsers(){
        return users;
    }
    
    // select one user by userId
    public User getUserByUserId(String userId){
        return users
                .stream()
                .filter(user->user.getUserId().equals(userId))
                .findAny()
                .orElse(new User(-1, "","", ""));
    }
    // user insert
    public yoonseo.seminar5.Model.User insertUser(yoonseo.seminar5.Model.User user){
        users.add(user);
        return user;
    }
    // modify
    public void updateUser(String userId, yoonseo.seminar5.Model.User user) {
        users.stream()
                .filter(curUser -> curUser.getUserId().equals(userId))
                .findAny()
                .orElse(new User(-1, "", "", ""))
                .setUserName(user.getUserName());
    }

    // delete
    public void deleteUser(String userId) {
        users.removeIf(user -> user.getUserId().equals(userId));
    }
}
