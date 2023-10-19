package com.plannerapp.controller;

import com.plannerapp.model.view.TaskHomeViewModel;
import com.plannerapp.service.TaskService;
import com.plannerapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private final CurrentUser currentUser;
    private final TaskService taskService;

    public HomeController(CurrentUser currentUser, TaskService taskService) {
        this.currentUser = currentUser;
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ModelAndView index() {

        if (currentUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("index");
    }

    @GetMapping("/home")
    public ModelAndView home() {

        if (!currentUser.isLogged()) {
            return new ModelAndView("redirect:/");
        }

        TaskHomeViewModel viewModel = taskService.getHomeAndViewData(currentUser.getUsername());

        return new ModelAndView("home", "tasks", viewModel);
    }
}
