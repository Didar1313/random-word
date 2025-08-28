package com.example.randomword.controller;

import com.example.randomword.model.word.WordResponse;
import com.example.randomword.service.WordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }

    @GetMapping("/wordOfTheDay")
    public WordResponse getWordOfTheDay() {
        return wordService.getWordOfTheDay();
    }
}
