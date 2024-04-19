package com.example.internal.SpringBootDockerProject.controller;


import com.example.internal.SpringBootDockerProject.exception.CustomResponseGETStatusException;
import com.example.internal.SpringBootDockerProject.exception.CustomResponsePOSTStatusException;
import com.example.internal.SpringBootDockerProject.service.Helloservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/hello")
public class HelloController {

    @Autowired
    final private Helloservice helloservice;

    public HelloController(Helloservice helloservice) {
        this.helloservice = helloservice;
    }

    @GetMapping("/greet")
    public String hello() {
        throw new CustomResponseGETStatusException("This should be a Post Request");

    }

    @PostMapping("/greet")
    public ResponseEntity<String> greet(@RequestBody String name) {

        if (name.equals("Sam")) {
            throw new CustomResponsePOSTStatusException("This should a Get Request");
        }
        return new ResponseEntity<>("Hello, " + name + "!", HttpStatus.ACCEPTED);
    }

    @GetMapping("/greetHello")
    public String hello1(@PathVariable String name) {
//validation
        return helloservice.getString(name);
    }

//    @GetMapping("/greetExample")
//   public  String getzStt(@PathVariable String name){
//        return "Samir";
//    }


}
