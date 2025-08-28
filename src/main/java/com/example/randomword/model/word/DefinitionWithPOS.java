package com.example.randomword.model.word;


public class DefinitionWithPOS {
    private String definition;
    private String partOfSpeech;

    public DefinitionWithPOS(String definition, String partOfSpeech) {
        this.definition = definition;
        this.partOfSpeech = partOfSpeech;
    }

    public String getDefinition() {
        return definition;
    }

    public String getPartOfSpeech() {
        return partOfSpeech;
    }
}