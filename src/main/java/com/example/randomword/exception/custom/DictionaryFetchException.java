package com.example.randomword.exception.custom;

public class DictionaryFetchException extends RuntimeException {
    public DictionaryFetchException(String message) {
        super(message);
    }
}
