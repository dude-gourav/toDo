package com.khatri.toDo.controller;

import com.khatri.toDo.dto.TaskRequest;
import com.khatri.toDo.model.Task;
import com.khatri.toDo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add_task")
    public ResponseEntity<?> createTask(@RequestBody TaskRequest taskRequest){
        try {
            Task task = new Task();
            task.setName(taskRequest.getName());
            task.setIsActive(taskRequest.getIsActive());
            task.setUserId(taskRequest.getUserId());
            return ResponseEntity.ok(taskService.createTask(task));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/remove_task/user_id/{userId}/task_id/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable Long userId, @PathVariable Long taskId){
        try{
            taskService.deleteTask(userId, taskId);
            return ResponseEntity.ok("Task deleted successfully");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
