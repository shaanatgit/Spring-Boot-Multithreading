package com.demo.multithreading.executor.api.controller;

import com.demo.multithreading.executor.api.entity.User;
import com.demo.multithreading.executor.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/users", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<User>> saveUsers(@RequestParam(value = "csvF") MultipartFile[] files) throws Exception {
        for (MultipartFile file : files) {
            userService.saveUser(file);
        }
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/users", produces= MediaType.APPLICATION_JSON_VALUE)
    public CompletableFuture<ResponseEntity> findAllUsers(){
        return  userService.findAllUsers().thenApply(ResponseEntity::ok);
        }

    @GetMapping(value = "/hello")
    public String helloUser(){
        return  "Hello welcome to the CompletableFuture example!!!!!!!!";
    }

    @GetMapping(value = "/getUsersByThread", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getUser(){
        CompletableFuture<List<User>> users1= userService.findAllUsers();
        CompletableFuture<List<User>> users2= userService.findAllUsers();
        CompletableFuture<List<User>> users3= userService.findAllUsers();
  CompletableFuture.allOf(users1,users2,users3).join().toString();

        return  ResponseEntity.status(HttpStatus.OK).build();
    }

}
