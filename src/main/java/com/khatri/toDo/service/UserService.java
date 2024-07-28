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

    public User saveUser(User user){
        return userRepository.save(user);
    }
    public Optional<User> getUserByName(String name){
        return userRepository.findByName(name);
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
