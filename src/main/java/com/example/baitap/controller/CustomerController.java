package com.example.baitap.controller;

import com.example.baitap.entity.Customer;
import com.example.baitap.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createCustomer(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") Long id) {
        return service.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Customer> getAll() {
        return service.getAllCustomers();
    }
}