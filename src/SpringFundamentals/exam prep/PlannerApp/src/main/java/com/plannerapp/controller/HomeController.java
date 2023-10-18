package com.plannerapp.controller;

import com.plannerapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
private final CurrentUser currentUser;

    public HomeController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/")
    public String index() {

        if (currentUser.isLogged()) {
            return "redirect:home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String home() {

        if (!currentUser.isLogged()) {
            return  "redirect:index";
        }

        return "home";
    }
}
