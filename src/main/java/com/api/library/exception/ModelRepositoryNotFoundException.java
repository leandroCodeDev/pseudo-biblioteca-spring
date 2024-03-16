package com.api.library.exception;



public class ModelRepositoryNotFoundException extends RuntimeException {
    public ModelRepositoryNotFoundException(String message) {
        super(message);
    }
}

