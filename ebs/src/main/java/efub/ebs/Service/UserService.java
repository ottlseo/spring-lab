package efub.ebs.Service;

import efub.ebs.DAO.UserDAO;
import efub.ebs.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDAO userDAO;

    public List<UserDTO> selectUser() throws Exception{
        return userDAO.select();
        // mapper클래스(userDAO)를 import 한 후, select()함수 불러옴
    }
}
