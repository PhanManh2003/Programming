package com.springboot.app1.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;

    // expose "/" endpoint that return Hello world
    @GetMapping
    public String sayHello(){
        return "Hello world dm";
    }

    @GetMapping("/devtool")
    public String checkDevTools(){
        return "Hello devtooaaa";
    }
}
