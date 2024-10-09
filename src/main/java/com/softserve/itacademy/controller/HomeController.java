package com.softserve.itacademy.controller;

import com.softserve.itacademy.service.VocabularyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final VocabularyService vocabularyService;

    public HomeController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @GetMapping({"/", "home"})
    public String home(Model model) {
        model.addAttribute("vocabularies", vocabularyService.getAll());
        return "home";
    }
}
