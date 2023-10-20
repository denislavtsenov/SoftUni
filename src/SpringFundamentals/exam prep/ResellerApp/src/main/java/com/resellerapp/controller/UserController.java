package com.resellerapp.controller;

import com.resellerapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private final CurrentUser currentUser;

    public UserController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/login")
    public String login() {

        if (currentUser.isLogged()) {
            return "redirect:/home";
        }

        return "login";
    }

    @GetMapping("/register")
    public String register() {

        if (currentUser.isLogged()) {
            return "redirect:/home";
        }

        return "register";
    }
}
