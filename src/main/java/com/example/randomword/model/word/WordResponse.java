package com.example.randomword.model.word;

import java.util.List;

public class WordResponse {

    private String word;
    private List<DefinitionWithPOS> definitions;

    public WordResponse(String word, List<DefinitionWithPOS> definitions) {
        this.word = word;
        this.definitions = definitions;
    }

    public String getWord() {
        return word;
    }

    public List<DefinitionWithPOS> getDefinitions() {
        return definitions;
    }
}
