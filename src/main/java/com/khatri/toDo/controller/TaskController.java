package com.khatri.toDo.controller;

import com.khatri.toDo.model.Task;
import com.khatri.toDo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping
public class TaskController {
    @Autowired
    public TaskService taskService;

    @GetMapping("/user_id/{userId}/task_id/{taskId}")
    public Optional<Task> getTaskById(@PathVariable Long userId, @PathVariable Long taskId){
        return taskService.getTaskById(userId, taskId);
    }
}
