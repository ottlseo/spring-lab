package yoonseo.seminar5.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yoonseo.seminar5.Dao.UserDao;
import yoonseo.seminar5.Model.User;

import java.util.List;

@Service
public class UserService {
    @Autowired //생성자와 setter 등 이용하여 자동으로 의존성 주입
    UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public User getUserByUserId(String userId) {
        return userDao.getUserByUserId(userId);
    }

    public User registerUser(User user) {
        return userDao.insertUser(user);
    }

    public void modifyUser(String userId, User user) {
        userDao.updateUser(userId, user);
    }

    public void removeUser(String userId) {
        userDao.deleteUser(userId);
    }

}
