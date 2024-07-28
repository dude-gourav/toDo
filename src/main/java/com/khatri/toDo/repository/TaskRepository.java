package com.khatri.toDo.repository;

import com.khatri.toDo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserIdAndIsActive(Long userId, Boolean isActive);
    Optional<Task> findByUserIdAndId(Long userId, Long id);
}
