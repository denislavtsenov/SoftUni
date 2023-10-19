package com.plannerapp.model.entity;

import com.plannerapp.model.enums.PriorityNameEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "priorities")
public class PriorityEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "priority_name", nullable = false, unique = true)
    private PriorityNameEnum priorityName;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "priority")
    private Set<TaskEntity> tasks;


    public PriorityEntity() {
    }

    public PriorityNameEnum getPriorityName() {
        return priorityName;
    }

    public void setPriorityName(PriorityNameEnum priorityName) {
        this.priorityName = priorityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(Set<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
