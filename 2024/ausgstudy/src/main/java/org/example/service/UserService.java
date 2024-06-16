package org.example.service;

import org.example.domain.model.User;
import org.example.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUserById(String userId){
        return userRepository.findById(userId);
    }
    public Optional<User> getUserByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
    public User register(User user){
        return userRepository.save(user);
    }
    public User update(String userId, User user){
        user.setUserId(userId);
        return userRepository.save(user);
    }
    public void remove(String userId){
        userRepository.deleteById(userId);
    }

}
