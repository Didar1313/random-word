package com.example.randomword.model.dictionary;

import com.example.randomword.model.word.DefinitionWithPOS;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Meaning {
    @Setter
    @Getter
    private String partOfSpeech;
    private List<DefinitionWithPOS> definitionWithPOS;

    public List<DefinitionWithPOS> getDefinitions() {
        return definitionWithPOS;
    }

    public void setDefinitions(List<DefinitionWithPOS> definitionWithPOS) {
        this.definitionWithPOS = definitionWithPOS;
    }
}