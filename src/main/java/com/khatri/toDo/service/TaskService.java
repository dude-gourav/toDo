package com.khatri.toDo.service;

import com.khatri.toDo.model.Task;
import com.khatri.toDo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Optional<Task> getTaskById(Long userId, Long taskId){
        return taskRepository.findByUserIdAndId(userId, taskId);
    }

    public Task saveTask(Task task){ return taskRepository.save(task); }

    public List<Task> getAllActiveTask(Long userId) {
        return taskRepository.findByUserIdAndIsActive(userId, Boolean.TRUE);
    }

    public List<Task> getAllInactiveTask(Long userId) {
        return taskRepository.findByUserIdAndIsActive(userId, Boolean.FALSE);
    }
}
