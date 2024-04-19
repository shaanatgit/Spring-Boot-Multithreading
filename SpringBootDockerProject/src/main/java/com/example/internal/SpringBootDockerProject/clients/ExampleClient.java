package com.example.internal.SpringBootDockerProject.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "exampleService", url = "${microservice-commonUrl}")
public interface ExampleClient {


    @GetMapping("/greetExample")
   public  String getzStt(@PathVariable String name);
}
