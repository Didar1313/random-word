package com.example.randomword.exception.custom;

public class WordFetchException extends RuntimeException {
    public WordFetchException(String message) {
        super(message);
    }
}

