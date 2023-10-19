package com.plannerapp.model.view;

import java.util.ArrayList;
import java.util.List;

public class TaskHomeViewModel {

    private List<TaskDTO> assignedTasks;
    private List<TaskDTO> availableTasks;

    private Integer availableTasksSize;

    public TaskHomeViewModel() {
       this(new ArrayList<>(), new ArrayList<>());
    }

    public TaskHomeViewModel(List<TaskDTO> assignedTasks, List<TaskDTO> availableTasks) {
        this.assignedTasks = assignedTasks;
        this.availableTasks = availableTasks;
        this.availableTasksSize = availableTasks.size();
    }

    public List<TaskDTO> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(List<TaskDTO> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }

    public List<TaskDTO> getAvailableTasks() {
        return availableTasks;
    }

    public void setAvailableTasks(List<TaskDTO> availableTasks) {
        this.availableTasks = availableTasks;
    }

    public Integer getAvailableTasksSize() {
        return availableTasksSize;
    }

    public void setAvailableTasksSize(Integer availableTasksSize) {
        this.availableTasksSize = availableTasksSize;
    }
}
