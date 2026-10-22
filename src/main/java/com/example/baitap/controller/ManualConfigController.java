package com.example.baitap.controller;

import com.example.baitap.service.ManualGreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManualConfigController {

    private final ManualGreetingService greetingService;

    public ManualConfigController(ManualGreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/manual-greet")
    public String greet(@RequestParam(name = "name", defaultValue = "Developer") String name) {
        return greetingService.sayHello(name);
    }
}