package com.example.internal.SpringBootDockerProject.exception;

public class CustomResponsePOSTStatusException extends  RuntimeException{

    public CustomResponsePOSTStatusException() {
    }

    public CustomResponsePOSTStatusException(String message) {
        super(message);
    }
}
