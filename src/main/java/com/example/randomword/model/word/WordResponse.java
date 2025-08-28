package com.example.randomword.model.word;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class WordResponse {

    private final String word;
    private final List<DefinitionWithPOS> definitions;

}
