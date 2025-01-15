package com.example.helloWord.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
    @GetMapping("/")
    public String healthCheck(){
        return "Hello World!";
    }
}
