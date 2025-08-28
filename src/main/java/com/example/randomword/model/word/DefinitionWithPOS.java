package com.example.randomword.model.word;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DefinitionWithPOS {
    private final String definition;
    private final String partOfSpeech;

}