package com.example.baitap.service;

import org.springframework.stereotype.Service;

//bài 2
@Service
public class GreetingService {
    public String sayHello(String name) {
        return "Hello " + name + "!";
    }
}