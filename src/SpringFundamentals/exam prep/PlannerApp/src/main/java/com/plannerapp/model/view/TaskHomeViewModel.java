package com.plannerapp.model.view;

import java.util.ArrayList;
import java.util.List;

public class TaskHomeViewModel {

    private List<TaskViewModel> assignedTasks;
    private List<TaskViewModel> availableTasks;

    private Integer availableTasksSize;

    public TaskHomeViewModel() {
       this(new ArrayList<>(), new ArrayList<>());
    }

    public TaskHomeViewModel(List<TaskViewModel> assignedTasks, List<TaskViewModel> availableTasks) {
        this.assignedTasks = assignedTasks;
        this.availableTasks = availableTasks;
        this.availableTasksSize = availableTasks.size();
    }

    public List<TaskViewModel> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<TaskViewModel> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }

    public List<TaskViewModel> getAvailableTasks() {
        return availableTasks;
    }

    public void setAvailableTasks(List<TaskViewModel> availableTasks) {
        this.availableTasks = availableTasks;
    }

    public Integer getAvailableTasksSize() {
        return availableTasksSize;
    }

    public void setAvailableTasksSize(Integer availableTasksSize) {
        this.availableTasksSize = availableTasksSize;
    }
}
