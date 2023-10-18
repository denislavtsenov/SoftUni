package com.plannerapp.model.service;

import com.plannerapp.model.entity.PriorityEntity;
import com.plannerapp.model.entity.UserEntity;

import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class TaskServiceModel {

    private Long id;
    private String description;
    private LocalDate dueDate;
    private PriorityEntity priority;
    private UserEntity user;

    public TaskServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public PriorityEntity getPriority() {
        return priority;
    }

    public void setPriority(PriorityEntity priority) {
        this.priority = priority;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
