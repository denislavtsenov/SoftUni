package com.plannerapp.controller;

import com.plannerapp.model.binding.UserLoginBindingModel;
import com.plannerapp.model.binding.UserRegisterBindingModel;
import com.plannerapp.model.service.UserServiceModel;
import com.plannerapp.service.UserService;
import com.plannerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public UserController(UserService userService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel() {
        return new UserLoginBindingModel();
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @GetMapping("/login")
    public String login(Model model) {

        if (currentUser.isLogged()) {
            return "redirect:/home";
        }

        if (!model.containsAttribute("isExists")) {
            model.addAttribute("isExists", true);
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }


        UserServiceModel user = userService.findByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

        if (user == null) {
            redirectAttributes
                    .addFlashAttribute("isExists", false)
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);

            return "redirect:login";
        }

        userService.loginUser(user.getId(), user.getUsername());

        return "redirect:/home";
    }

    @GetMapping("/register")
    public String register() {

        if (currentUser.isLogged()) {
            return "redirect:/home";
        }

        return "register";
    }


    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        boolean samePasswords = userRegisterBindingModel.getPassword()
                .equals(userRegisterBindingModel.getConfirmPassword());

        if (bindingResult.hasErrors() || !samePasswords) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            return "redirect:register";
        }

        userService.registerUser(modelMapper.map(
                userRegisterBindingModel, UserServiceModel.class
        ));

        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout() {

        userService.logoutUser();

        return "redirect:/";
    }

}
