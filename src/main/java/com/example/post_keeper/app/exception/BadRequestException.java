package com.example.post_keeper.app.exception;

abstract public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}

