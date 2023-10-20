package com.resellerapp.controller;

import com.resellerapp.model.binding.OfferAddBindingModel;
import com.resellerapp.model.service.OfferServiceModel;
import com.resellerapp.service.OfferService;
import com.resellerapp.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class OfferController {

    private final CurrentUser currentUser;
    private final OfferService offerService;
    private final ModelMapper modelMapper;

    public OfferController(CurrentUser currentUser, OfferService offerService, ModelMapper modelMapper) {
        this.currentUser = currentUser;
        this.offerService = offerService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/offer/add")
    public String addOffer() {

        if (!currentUser.isLogged()) {
            return "redirect:/";
        }
        return "offer-add";
    }

    @PostMapping("offer/add")
    public String addOfferConfirm(@Valid OfferAddBindingModel offerAddBindingModel,
                                  BindingResult bindingResult,
                                  RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("offerAddBindingModel", offerAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.offerAddBindingModel", bindingResult);

            return "redirect:addOffer";
        }

        offerService.addOffer(modelMapper.map(
                offerAddBindingModel, OfferServiceModel.class));

        return "redirect:/home";
    }

    @ModelAttribute
    public OfferAddBindingModel offerAddBindingModel() {
        return new OfferAddBindingModel();
    }
}
