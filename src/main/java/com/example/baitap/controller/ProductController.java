package com.example.baitap.controller;

import com.example.baitap.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

//bài 4
@RestController
@RequestMapping("/products")
public class ProductController {

    private final List<Product> products = new CopyOnWriteArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    @GetMapping
    public List<Product> getAll() {
        return products;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product product) {
        product.setId(idCounter.getAndIncrement());
        products.add(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable("id") Long id, @RequestBody Product request) {
        for (Product p : products) {
            if (p.getId().equals(id)) {
                p.setName(request.getName());
                p.setPrice(request.getPrice());
                return ResponseEntity.ok(p);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        boolean removed = products.removeIf(p -> p.getId().equals(id));
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}