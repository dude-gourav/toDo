package com.khatri.toDo.service;

import com.khatri.toDo.repository.UserRepository;
import com.khatri.toDo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserByName(String name){
        return userRepository.findByName(name);
    }

    public Optional<User> getUserByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user) {
        if (getUserByUserName(user.getUserName()).isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        }
        return userRepository.save(user);
    }

    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
}
