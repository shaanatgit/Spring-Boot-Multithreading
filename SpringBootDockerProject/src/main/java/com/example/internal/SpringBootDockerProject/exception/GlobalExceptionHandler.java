package com.example.internal.SpringBootDockerProject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomResponseGETStatusException.class)
    protected ResponseEntity<Object> handleWrongMethod(CustomResponseGETStatusException ex) {
        RestError error = new RestError(HttpStatus.METHOD_NOT_ALLOWED, ex.getMessage(), "GET");
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);

    }

    @ExceptionHandler(CustomResponsePOSTStatusException.class)
    protected ResponseEntity<Object> handleWrongMethod(CustomResponsePOSTStatusException ex) {
        RestError error = new RestError(HttpStatus.CONFLICT, ex.getMessage(), "POST");
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);

    }
}
