package com.khatri.toDo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "task", schema = "data")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "is_active")
    private Boolean isActive;

    public Task() {
    }

    public Task(Long id, String name, Long userId, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.userId = userId;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                ", name='" + name + '\'' +
                ", user_id=" + userId +
                ", is_active=" + isActive +
                '}';
    }
}
