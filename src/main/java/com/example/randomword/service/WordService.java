package com.example.randomword.service;

import com.example.randomword.model.dictionary.DictionaryResponse;
import com.example.randomword.model.word.DefinitionWithPOS;
import com.example.randomword.model.word.WordResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WordService {

    private final RestTemplate restTemplate;

    public WordService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Cacheable("wordOfTheDay")
    public WordResponse getWordOfTheDay() {
        String word;
        List<DefinitionWithPOS> definitions;

        do {
            // fetch random word
            String[] words = restTemplate.getForObject(
                    "https://random-word-api.herokuapp.com/word",
                    String[].class
            );
            word = (words != null && words.length > 0) ? words[0] : null;

            // fetch dictionary
            DictionaryResponse[] dictionaryResponses = null;
            if (word != null) {
                try {
                    dictionaryResponses = restTemplate.getForObject(
                            "https://api.dictionaryapi.dev/api/v2/entries/en/{word}",
                            DictionaryResponse[].class,
                            word
                    );
                } catch (Exception ignored) { }
            }

            definitions = (dictionaryResponses != null && dictionaryResponses.length > 0)
                    ? dictionaryResponses[0].getMeanings().stream()
                    .flatMap(m -> m.getDefinitions().stream()
                            .map(def -> new DefinitionWithPOS(def.getDefinition(), m.getPartOfSpeech())))
                    .toList()
                    : List.of();

        } while (definitions.isEmpty()); // keep trying until we get a valid word

        return new WordResponse(word, definitions);
    }
}
