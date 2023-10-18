package com.plannerapp.model.binding;

import com.plannerapp.model.enums.PriorityNameEnum;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class TaskBindingModel {


    @Length(min = 2, max = 50, message = "Description length must be between 2 and 50 characters")
    private String description;

    @Future(message = "The dueDate must be a positive in the future.")
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
}
