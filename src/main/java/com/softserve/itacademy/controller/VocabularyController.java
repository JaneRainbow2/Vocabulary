package com.softserve.itacademy.controller;

import com.softserve.itacademy.dto.VocabularyDto;
import com.softserve.itacademy.model.Vocabulary;
import com.softserve.itacademy.service.VocabularyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/voc")
@RequiredArgsConstructor
public class VocabularyController {

    private final VocabularyService vocabularyService;

    @GetMapping("/create")
    public String createVocabularyForm(Model model) {
        model.addAttribute("vocabulary", new Vocabulary());
        return "create-vocabulary";
    }

    @PostMapping("/create")
    public String createVocabulary(@ModelAttribute Vocabulary vocabulary) {
        vocabularyService.create(vocabulary);
        return "redirect:/voc/all";
    }

    @GetMapping("/{id}/read")
    public String read(@PathVariable("id") long id, Model model) {
        VocabularyDto vocabularyDto = vocabularyService.findByIdThrowing(id);
        model.addAttribute("vocabulary", vocabularyDto);
        return "vocabulary-info";
    }


    @GetMapping("/{id}/update")
    public String update(@PathVariable long id, Model model) {
        Vocabulary vocabulary = vocabularyService.readById(id);
        model.addAttribute("vocabulary", vocabulary);
        return "update-vocabulary";
    }

    @PostMapping("/{id}/update")
    public String update(@PathVariable long id, Model model,
                         @Validated @ModelAttribute("vocabulary") VocabularyDto vocabularyDto, BindingResult result) {
       VocabularyDto oldVocabulary = vocabularyService.findByIdThrowing(id);

        if (result.hasErrors()) {
            return "update-vocabulary";
        }
        vocabularyService.update(vocabularyDto);
        return "redirect:/voc/all";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id) {
        vocabularyService.delete(id);
        return "redirect:/voc/all";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
        model.addAttribute("vocabularies", vocabularyService.getAll());
        return "vocabulary-list";
    }
}
