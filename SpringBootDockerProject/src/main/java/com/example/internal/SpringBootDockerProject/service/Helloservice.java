package com.example.internal.SpringBootDockerProject.service;

import com.example.internal.SpringBootDockerProject.clients.ExampleClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Helloservice {

    @Autowired
    final private ExampleClient exampleClient;

    public Helloservice(ExampleClient exampleClient) {
        this.exampleClient = exampleClient;
    }

    public String getString(String name) {
        return exampleClient.getzStt(name);
    }
}
