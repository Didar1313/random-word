package com.example.randomword.controller;

import com.example.randomword.model.word.WordResponse;
import com.example.randomword.service.WordService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class WordController {

    private final WordService wordService;

    @Operation(summary = "Get the word")
    @GetMapping("/wordOfTheDay")
    public WordResponse getWordOfTheDay() {
        return wordService.getWordOfTheDay();
    }
}
