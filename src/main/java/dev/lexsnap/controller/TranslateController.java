package dev.lexsnap.controller;

import dev.lexsnap.service.TranslateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class TranslateController {
    private final TranslateService translateService;

    @GetMapping
    public String index(Model model) {
        var words = translateService.getWords();
        model.addAttribute("words", words);
        return "index";
    }

    @PostMapping
    public String translate(@RequestParam String word, Model model) {
        var result = translateService.translate(word);
        model.addAttribute("word", word);
        model.addAttribute("result", result);

        var words = translateService.getWords();
        model.addAttribute("words", words);

        return "index";
    }
}
