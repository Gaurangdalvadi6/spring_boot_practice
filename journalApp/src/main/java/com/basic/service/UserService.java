package com.basic.service;

import com.basic.entity.User;
import com.basic.repository.UserRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return  userRepository.findAll();
    }

    public User getUser(Long id){
        return userRepository.findById(id).orElseThrow(()-> new RuntimeException("User Not Found : "+id));
    }

    public  User updateUser(User user, Long id){
        User user1 = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found : " + id));
        user1.setUsername(user.getUsername());
        user1.setPassword(user.getPassword());
        return userRepository.save(user1);
    }

    public void deleteUser(Long id){
        User user1 = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found : " + id));
        userRepository.delete(user1);
//        return true;
    }
}
