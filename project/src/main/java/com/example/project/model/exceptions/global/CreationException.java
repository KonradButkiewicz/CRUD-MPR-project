package com.example.project.model.exceptions.global;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CreationException extends RuntimeException {
    public CreationException(String message) {
        super(message);
    }
}

