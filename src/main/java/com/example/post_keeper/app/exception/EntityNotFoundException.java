package com.example.post_keeper.app.exception;

public class EntityNotFoundException extends BadRequestException {
    public EntityNotFoundException(String type, Long id) {
        super("Not found " + type +" by id #" + id);
    }
}
