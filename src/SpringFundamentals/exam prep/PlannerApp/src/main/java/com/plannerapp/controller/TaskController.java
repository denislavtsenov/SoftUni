package com.plannerapp.controller;

import com.plannerapp.model.binding.TaskBindingModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TaskController {

    @GetMapping("/tasks/add")
    public String add() {
        return "task-add";
    }

//    @PostMapping("/tas
//    ks/add")
//    public String addConfirm(TaskBindingModel taskBindingModel,
//                             BindingResult bindingResult,
//                             RedirectAttributes redirectAttributes) {
//
//        if (bindingResult.hasErrors()) {
//            redirectAttributes
//                    .addFlashAttribute("taskBindingModel", taskBindingModel)
//                    .addFlashAttribute("org.springframework.validation.BindingResult.taskBindingModel", bindingResult);
//
//            return "redirect:add";
//        }
//
//
//        return "home";
//
//    }
}
