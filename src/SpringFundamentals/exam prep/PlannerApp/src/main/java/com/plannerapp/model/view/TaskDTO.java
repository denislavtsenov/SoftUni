package com.plannerapp.model.view;

import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.model.enums.PriorityNameEnum;

public class TaskDTO {
    private Long id;

    private String description;

    private String dueDate;

    private PriorityNameEnum priority;

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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public PriorityNameEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityNameEnum priority) {
        this.priority = priority;
    }

    public static TaskDTO createFromTask(TaskEntity task) {
        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId(task.getId());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setPriority(task.getPriority().getPriorityName());
        taskDTO.setDueDate(task.getDueDate().toString());

        return taskDTO;
    }
}
