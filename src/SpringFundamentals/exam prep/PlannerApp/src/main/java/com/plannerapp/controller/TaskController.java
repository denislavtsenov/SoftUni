package com.plannerapp.controller;

import com.plannerapp.model.binding.TaskBindingModel;
import com.plannerapp.model.service.TaskServiceModel;
import com.plannerapp.service.TaskService;
import com.plannerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class TaskController {

    private final TaskService taskService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public TaskController(TaskService taskService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.taskService = taskService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @GetMapping("/tasks/add")
    public String add() {

        if (!currentUser.isLogged()) {
            return "redirect:/";
        }

        return "task-add";
    }

    @PostMapping("/tasks/add")
    public String addConfirm(@Valid TaskBindingModel taskBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("taskBindingModel", taskBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.taskBindingModel", bindingResult);

            return "redirect:add";
        }


        taskService.addTask(modelMapper.map(
                taskBindingModel, TaskServiceModel.class
        ));

        return "/home";

    }

    @PostMapping("tasks/remove/{id}")
    public String remove(@PathVariable("id") Long id) {
        if (!currentUser.isLogged()) {
            return "redirect:/";
        }

        taskService.remove(id);

        return "redirect:/home";
    }

    @PostMapping("tasks/return/{id}")
    public String returnTask (@PathVariable("id") Long id) {

        if (!currentUser.isLogged()) {
            return "redirect:/";
        }

        taskService.assign(id, null);

        return "redirect:/home";
    }

    @PostMapping("tasks/assign/{id}")
    public String assign(@PathVariable("id") Long id) {
        if (!currentUser.isLogged()) {
            return "redirect:/";
        }

        taskService.assign(id, currentUser.getUsername());

        return "redirect:/home";
    }

    @ModelAttribute
    public TaskBindingModel taskBindingModel() {
        return new TaskBindingModel();
    }


}
