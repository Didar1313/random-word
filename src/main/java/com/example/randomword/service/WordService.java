package com.example.randomword.service;

import com.example.randomword.model.word.WordResponse;
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

    public WordResponse getWordOfTheDay() {
        // Fetch random word
        String[] words = randomWordClient.get()
                .uri("/word")
                .retrieve()
                .bodyToMono(String[].class)
                .block();

        if (words == null || words.length == 0) {
            throw new RuntimeException("Failed to fetch random word");
        }

        String word = words[0];
        return new WordResponse(word, null);
    }
}
