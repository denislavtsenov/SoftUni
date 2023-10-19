package com.plannerapp.controller;

import com.plannerapp.service.TaskService;
import com.plannerapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final TaskService taskService;

    public HomeController(CurrentUser currentUser, TaskService taskService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
    }

    @GetMapping("/index")
    public String index() {

        if (!currentUser.isLogged()) {
            return "index";
        }

        return "redirect:home";
    }

    @GetMapping("/home")
    public String home(Model model) {

        if (!currentUser.isLogged()) {
            return "redirect:index";
        }

        model.addAttribute("allTasks", taskService.getAllTasks());
        model.addAttribute("assignedTasks", taskService.getAssignedTasks());
        model.addAttribute("allUnassignedTasksSize", taskService.getAllTasks().size());

        return "home";
    }

}
