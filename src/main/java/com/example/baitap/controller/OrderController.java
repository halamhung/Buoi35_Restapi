package com.example.baitap.controller;

import com.example.baitap.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final List<Order> orders = new CopyOnWriteArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        order.setId(idGenerator.getAndIncrement());
        orders.add(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orders;
    }
}