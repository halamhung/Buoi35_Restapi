package com.example.baitap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Bài 1 API Hello World
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
}