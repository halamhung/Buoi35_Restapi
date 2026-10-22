package com.example.baitap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//bài 3
@RestController
@RequestMapping("/calc")
public class CalculatorController {

    @GetMapping("/add")
    public double add(@RequestParam("x") double x, @RequestParam("y") double y) {
        return x + y;
    }

    @GetMapping("/subtract")
    public double subtract(@RequestParam("x") double x, @RequestParam("y") double y) {
        return x - y;
    }

    @GetMapping("/multiply")
    public double multiply(@RequestParam("x") double x, @RequestParam("y") double y) {
        return x * y;
    }

    @GetMapping("/divide")
    public ResponseEntity<?> divide(@RequestParam("x") double x, @RequestParam("y") double y) {
        if (y == 0) {
            return ResponseEntity.badRequest().body("Lỗi: Không thể chia cho 0");
        }
        return ResponseEntity.ok(x / y);
    }
}