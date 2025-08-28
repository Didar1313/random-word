package com.example.randomword.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WordService {

    private final WebClient randomWordClient;
    private final WebClient dictionaryClient;

    public WordService(WebClient.Builder builder) {
        this.randomWordClient = builder.baseUrl("https://random-word-api.herokuapp.com").build();
        this.dictionaryClient = builder.baseUrl("https://api.dictionaryapi.dev/api/v2/entries/en").build();
    }

}
