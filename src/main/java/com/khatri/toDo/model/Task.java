package com.khatri.toDo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task", schema = "data")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "task")
    private String task;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "is_active")
    private Boolean isActive;

    public Task() {
    }

    public Task(Long id, String task, Long userId, Boolean isActive) {
        this.id = id;
        this.task = task;
        this.userId = userId;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "task{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", user_id=" + userId +
                ", is_active=" + isActive +
                '}';
    }
}
