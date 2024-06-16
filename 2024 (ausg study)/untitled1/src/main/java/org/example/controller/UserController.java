package org.example.controller;

import org.example.domain.model.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")  // e.g. GET http://localhost:8080/user/list
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable String userId) throws Exception {
        return userService.getUserById(userId)
                .orElseThrow(() -> new Exception("User not found with id: " + userId));
    }
    @PostMapping("/register")
    public String register(@RequestBody User user){
        return userService.register(user).getUserId();
    }
    @PutMapping("/{userId}") // update user info
    public String modify(@PathVariable String userId, @RequestBody User user){
        return userService.update(userId, user).getUserId();
    }
    @DeleteMapping("/{userId}") // delete user
    public void removeUser(@PathVariable String userId){
        userService.remove(userId);
    }
}
