package com.example.baitap.controller;

import com.example.baitap.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//bài 2
public class GreetingController {

    private final GreetingService greetingService;

    // Constructor Injection (chuẩn khuyến nghị của Spring)
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet")
    public String greet(@RequestParam(name = "name", defaultValue = "World") String name) {
        return greetingService.sayHello(name);
    }
}