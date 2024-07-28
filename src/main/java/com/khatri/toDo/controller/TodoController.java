package com.khatri.toDo.controller;

import com.khatri.toDo.model.Task;
import com.khatri.toDo.model.User;
import com.khatri.toDo.service.TaskService;
import com.khatri.toDo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class TodoController{
    @Autowired
    public UserService userService;

    @Autowired
    public TaskService taskService;

    @GetMapping("/users/{name}")
    public Optional<User> getByName(@PathVariable String name){
        return userService.getUserByName(name);
    }

    @GetMapping("/users/all")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user_id/{userId}/task_id/{taskId}")
    public Optional<Task> getTaskById(@PathVariable Long userId, @PathVariable Long taskId){
        return taskService.getTaskById(userId, taskId);
    }
}
