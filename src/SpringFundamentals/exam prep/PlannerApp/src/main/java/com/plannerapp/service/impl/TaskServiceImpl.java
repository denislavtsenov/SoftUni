package com.plannerapp.service.impl;

import com.plannerapp.model.entity.PriorityEntity;
import com.plannerapp.model.entity.TaskEntity;
import com.plannerapp.model.entity.UserEntity;
import com.plannerapp.model.service.TaskServiceModel;
import com.plannerapp.model.view.TaskDTO;
import com.plannerapp.model.view.TaskHomeViewModel;
import com.plannerapp.repo.PriorityRepository;
import com.plannerapp.repo.TaskRepository;
import com.plannerapp.repo.UserRepository;
import com.plannerapp.service.TaskService;
import com.plannerapp.service.UserService;
import com.plannerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;
    private final PriorityRepository priorityRepository;
    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final UserService userService;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper, PriorityRepository priorityRepository, UserRepository userRepository, CurrentUser currentUser, UserService userService) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
        this.priorityRepository = priorityRepository;
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.userService = userService;
    }


    @Override
    public void addTask(TaskServiceModel taskServiceModel) {
        PriorityEntity priority = priorityRepository.findByPriorityName(taskServiceModel.getPriority());

        if (priority != null) {
            TaskEntity task = modelMapper.map(taskServiceModel, TaskEntity.class);
            task.setDescription(taskServiceModel.getDescription());
            task.setDueDate(taskServiceModel.getDueDate());
            task.setPriority(priority);

            taskRepository.save(task);
        }
    }

    @Override
    public void remove(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void assign(Long id, String username) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);

        if (optionalTask.isPresent()) {
            TaskEntity task = optionalTask.get();


            if (username == null) {
                task.setAssignee(null);
            } else {
                UserEntity user = userRepository.findByUsername(username);
                task.setAssignee(user);
            }

            taskRepository.save(task);
        }
    }

    @Override
    public TaskHomeViewModel getHomeAndViewData(String username) {

        UserEntity user = userRepository.findByUsername(username);

        List<TaskDTO> assignedTasks =
                taskRepository.findByAssignee(user).stream()
                        .map(TaskDTO::createFromTask)
                        .collect(Collectors.toList());

        List<TaskDTO> availableTasks = taskRepository.getAllAvailable().stream()
                .map(TaskDTO::createFromTask)
                .collect(Collectors.toList());

        return new TaskHomeViewModel(assignedTasks, availableTasks);
    }
}
