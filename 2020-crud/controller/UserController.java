package ottl.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ottl.crud.domain.User;
import ottl.crud.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")  // localhost:8080/user/list
    public List<User> getAllUsers(){
        return userService.getUserList();
    }
    @GetMapping("/{userId}")
    public User getUserByUserId(@PathVariable String userId){
        return userService.getUserById(userId);
    }
    @PostMapping("")  // 이때 어떻게 보낼 것인가? 영상 보기 v
    public User register(@RequestBody User user){  // RequestBody 뭐지?
        return userService.register(user);
    }
    @PutMapping("/{userId}")  //put과 post의 다른 점은 ?
    public void modify(@PathVariable String userId, @RequestBody User user){
        userService.update(userId, user);
    }
    @DeleteMapping("/{userId}")
    public void removeUser(@PathVariable String userId){
        userService.removeUser(userId);
    }
}
