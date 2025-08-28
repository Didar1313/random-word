package com.example.randomword.model.dictionary;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class DictionaryResponse {
    private String word;
    private List<Meaning> meanings;

}