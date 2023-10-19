package com.plannerapp.service;

import com.plannerapp.model.binding.TaskBindingModel;
import com.plannerapp.model.enums.PriorityNameEnum;
import com.plannerapp.model.service.TaskServiceModel;
import com.plannerapp.model.view.TaskHomeViewModel;

import java.time.LocalDate;

public interface TaskService {
    void addTask(TaskServiceModel taskServiceModel);

    void remove(Long id);

    void assign(Long id, String username);

    TaskHomeViewModel getHomeAndViewData(String username);
}
