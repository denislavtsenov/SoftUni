package com.dictionaryapp.controller;

import com.dictionaryapp.model.binding.WordAddBindingModel;
import com.dictionaryapp.model.service.WordServiceModel;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.CurrentUser;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class WordController {

    private final WordService wordService;
    private final ModelMapper modelMapper;
    private final CurrentUser currentUser;

    public WordController(WordService wordService, ModelMapper modelMapper, CurrentUser currentUser) {
        this.wordService = wordService;
        this.modelMapper = modelMapper;
        this.currentUser = currentUser;
    }

    @ModelAttribute
    public WordAddBindingModel wordAddBindingModel() {
        return new WordAddBindingModel();
    }

    @GetMapping("/words/add")
    public String add() {

        if (!currentUser.isLogged()) {
            return "redirect:/";
        }

        return "word-add";
    }


    @PostMapping("/words/add")
    public String addConfirm(@Valid WordAddBindingModel wordAddBindingModel,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("wordAddBindingModel", wordAddBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.wordAddBindingModel", bindingResult);

            return "redirect:add";
        }

        wordService.addWord(modelMapper.map(
                wordAddBindingModel, WordServiceModel.class
        ));

        return "redirect:/home";
    }

    @GetMapping("/words/remove/{id}")
    public String remove(@PathVariable("id") Long id) {

        if (!currentUser.isLogged()) {
            return "redirect:/";
        }

        wordService.remove(id);

        return "redirect:/home";
    }

}
