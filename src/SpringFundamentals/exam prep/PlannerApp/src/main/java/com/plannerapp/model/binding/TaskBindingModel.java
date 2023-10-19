package com.plannerapp.model.binding;

import com.plannerapp.model.enums.PriorityNameEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TaskBindingModel {


    @NotNull
    @Length(min = 2, max = 50, message = "Description length must be between 2 and 50 characters")
    private String description;

    @NotNull
    @Future(message = "The dueDate must be a positive in the future.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @NotNull(message = "You must select priority!")
    private PriorityNameEnum priority;

    public TaskBindingModel() {
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
}
