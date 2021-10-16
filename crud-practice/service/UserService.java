package ottl.crud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ottl.crud.dao.UserDao;
import ottl.crud.domain.User;

import java.util.List;

@Service
public class UserService {  // 서비스 로직은 Dao에서 정의한 함수를 쓰는 걸로
    @Autowired
    UserDao userDao;

    public List<User> getUserList(){
        return userDao.getAllUsers();
    }
    public User getUserById(String userId){
        return userDao.getUserByUserId(userId); //userDao에서 찾아라
    }
    public User register(User user){
        return userDao.insertUser(user);
    }
    public void update(String userId, User user){
        userDao.updateUser(userId, user);
    }
    public void removeUser(String userId){
        userDao.deleteUser(userId);
    }
}
