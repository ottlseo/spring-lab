package efub.ebs.Controller;

import efub.ebs.DAO.UserDAO;
import efub.ebs.DTO.UserDTO;

import efub.ebs.Service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService; // UserDAO bean을 자동으로 주입

    @RequestMapping("home")
    public List<UserDTO> home() throws Exception{
        List<UserDTO> re = userService.selectUser();
        //System.out.println(re.get(0).getDescription());
        return re;
    }

    /*
    @RequestMapping("/users")  //users 라는 URL로 응답
    public List<UserDTO> users(@RequestParam(value="name", defaultValue = "") String name) throws Exception{
        final UserDTO param = new UserDTO(0, name, null);//전달 받은 name을 받은 UserDTO 객체 생성- 이 객체는 MyBatis에 파라미터로 전달
        final List<UserDTO> userList = userDAO.selectUsers(param);// 윗줄에서 생성한 객체를 파라미터로 전달하여 DB로부터 사용자 목록을 불러온다.
        return userList;
    }
     */
}
