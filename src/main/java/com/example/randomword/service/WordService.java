package com.example.randomword.service;

import com.example.randomword.model.dictionary.DictionaryResponse;
import com.example.randomword.model.word.DefinitionWithPOS;
import com.example.randomword.model.word.WordResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class WordService {

    private final WebClient randomWordClient;
    private final WebClient dictionaryClient;

    public WordService(WebClient.Builder builder) {
        this.randomWordClient = builder.baseUrl("https://random-word-api.herokuapp.com").build();
        this.dictionaryClient = builder.baseUrl("https://api.dictionaryapi.dev/api/v2/entries/en").build();
    }

    @Cacheable("wordOfTheDay")
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

        // Fetch definitions from dictionary API
        DictionaryResponse[] dictionaryResponses = dictionaryClient.get()
                .uri("/{word}", word)
                .retrieve()
                .bodyToMono(DictionaryResponse[].class)
                .onErrorReturn(new DictionaryResponse[0])
                .block();

        if (dictionaryResponses == null || dictionaryResponses.length == 0) {
            return new WordResponse(word, List.of());
        }
        // Extract definitions
        List<DefinitionWithPOS> definitions = dictionaryResponses[0].getMeanings().stream()
                .flatMap(meaning -> meaning.getDefinitions().stream()
                        .map(def -> new DefinitionWithPOS(def.getDefinition(), meaning.getPartOfSpeech())))
                .toList();

        return new WordResponse(word, definitions);
    }
}
