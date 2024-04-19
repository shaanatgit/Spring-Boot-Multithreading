package com.example.internal.SpringBootDockerProject.exception;

public class CustomResponseGETStatusException extends  RuntimeException{

    public CustomResponseGETStatusException() {
        super();
    }

    public CustomResponseGETStatusException(String message ) {
    super(message);


    }

    public CustomResponseGETStatusException(String message, Throwable cause) {
        super(message, cause);
    }
}
