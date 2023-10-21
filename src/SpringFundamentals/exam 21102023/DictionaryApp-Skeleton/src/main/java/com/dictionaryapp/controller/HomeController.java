package com.dictionaryapp.controller;

import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.CurrentUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final CurrentUser currentUser;
    private final WordService wordService;

    public HomeController(CurrentUser currentUser, WordService wordService){
        this.currentUser = currentUser;
        this.wordService = wordService;

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

        int count = wordService.findAllByGermanLanguage().size()
                + wordService.findAllByFrenchLanguage().size()
                + wordService.findAllByItalianLanguage().size()
                + wordService.findAllBySpanishLanguage().size();

        model.addAttribute("allCount", count);

        model.addAttribute("french", wordService.findAllByFrenchLanguage());
        model.addAttribute("frenchSize", wordService.findAllByFrenchLanguage().size());

        model.addAttribute("spanish", wordService.findAllBySpanishLanguage());
        model.addAttribute("spanishSize", wordService.findAllBySpanishLanguage().size());

        model.addAttribute("german", wordService.findAllByGermanLanguage());
        model.addAttribute("germanSize", wordService.findAllByGermanLanguage().size());

        model.addAttribute("italian", wordService.findAllByItalianLanguage());
        model.addAttribute("italianSize", wordService.findAllByItalianLanguage().size());

        return "home";
    }

    @GetMapping("/home/remove-all")
    public String removeAll() {

        wordService.removeAll();

        return "redirect:/home";
    }
}
