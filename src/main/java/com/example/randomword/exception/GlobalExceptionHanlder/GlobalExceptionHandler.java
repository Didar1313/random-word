package com.example.randomword.exception.GlobalExceptionHanlder;

import com.example.randomword.exception.custom.DictionaryFetchException;
import com.example.randomword.exception.custom.WordFetchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WordFetchException.class)
    public ResponseEntity<Object> handleWordFetchException(WordFetchException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Map.of(
                        "timestamp", LocalDateTime.now(),
                        "error", "Word Fetch Error",
                        "message", ex.getMessage()
                ));
    }

    @ExceptionHandler(DictionaryFetchException.class)
    public ResponseEntity<Object> handleDictionaryFetchException(DictionaryFetchException ex) {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Map.of(
                        "timestamp", LocalDateTime.now(),
                        "error", "Dictionary Fetch Error",
                        "message", ex.getMessage()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of(
                        "timestamp", LocalDateTime.now(),
                        "error", "Internal Server Error",
                        "message", ex.getMessage()
                ));
    }
}
