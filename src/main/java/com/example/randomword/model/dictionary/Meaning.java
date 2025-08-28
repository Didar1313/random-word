package com.example.randomword.model.dictionary;

import com.example.randomword.model.word.DefinitionWithPOS;

import java.util.List;

public class Meaning {
    private String partOfSpeech;
    private List<DefinitionWithPOS> definitionWithPOS;

    public String getPartOfSpeech() {
        return partOfSpeech;
    }

    public void setPartOfSpeech(String partOfSpeech) {
        this.partOfSpeech = partOfSpeech;
    }

    public List<DefinitionWithPOS> getDefinitions() {
        return definitionWithPOS;
    }

    public void setDefinitions(List<DefinitionWithPOS> definitionWithPOS) {
        this.definitionWithPOS = definitionWithPOS;
    }
}