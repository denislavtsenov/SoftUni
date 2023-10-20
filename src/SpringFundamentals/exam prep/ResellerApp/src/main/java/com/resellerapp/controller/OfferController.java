package com.resellerapp.controller;

import com.resellerapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfferController {

    private final CurrentUser currentUser;

    public OfferController(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }

    @GetMapping("/offer/add")
    public String addOffer() {

        if (!currentUser.isLogged()) {
            return "redirect:/index";
        }
        return "offer-add";
    }
}
