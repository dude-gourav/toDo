package com.khatri.toDo.controller;

import com.khatri.toDo.dto.UserRequest;
import com.khatri.toDo.model.User;
import com.khatri.toDo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class UserController {
    @Autowired
    public UserService userService;

    @GetMapping("/users/{name}")
    public Optional<User> getByName(@PathVariable String name){
        return userService.getUserByName(name);
    }

    @GetMapping("/users/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/add_user")
    public ResponseEntity<?> createUser(@RequestBody UserRequest userRequest){
        try {
            User user = new User();
            user.setName(userRequest.getName());
            user.setUserName(userRequest.getUserName());
            user.setPassword(userRequest.getPassword());
            user.setMail(userRequest.getMail());

            User savedUser = userService.createUser(user);
            return ResponseEntity.ok(savedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/remove_user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        try{
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
