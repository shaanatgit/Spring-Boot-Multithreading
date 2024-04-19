package com.example.internal.SpringBootDockerProject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@AllArgsConstructor
public class RestError  {

    private HttpStatus status;

    private String message;

    private String methodName;

}
