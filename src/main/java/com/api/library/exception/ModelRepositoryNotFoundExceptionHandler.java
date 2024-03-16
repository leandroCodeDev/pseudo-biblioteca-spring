package com.api.library.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ModelRepositoryNotFoundExceptionHandler {

    @ExceptionHandler(ModelRepositoryNotFoundException.class)
    public ResponseEntity<Object> handleModelRepositoryNotFoundException(ModelRepositoryNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
