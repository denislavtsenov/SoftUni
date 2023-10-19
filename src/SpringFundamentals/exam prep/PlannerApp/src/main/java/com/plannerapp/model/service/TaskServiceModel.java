package com.plannerapp.model.service;

import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.model.enums.PriorityNameEnum;

import java.time.LocalDate;

public class TaskServiceModel {

    private Long id;
    private String description;
    private LocalDate dueDate;
    private PriorityNameEnum priority;
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

    public PriorityNameEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityNameEnum priority) {
        this.priority = priority;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public static TaskServiceModel createFromTask(TaskEntity task) {

        TaskServiceModel taskServiceModel = new TaskServiceModel();

        taskServiceModel.setId(task.getId());
        taskServiceModel.setDescription(task.getDescription());
        taskServiceModel.setPriority(task.getPriority().getPriorityName());
        taskServiceModel.setDueDate(task.getDueDate());

        return taskServiceModel;
    }
}
