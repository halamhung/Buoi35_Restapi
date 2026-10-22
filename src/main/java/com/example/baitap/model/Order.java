package com.example.baitap.model;

import java.util.List;

public class Order {
    private Long id;
    private String customerName;
    private List<Product> products;

    public Order() {}

    public Order(Long id, String customerName, List<Product> products) {
        this.id = id;
        this.customerName = customerName;
        this.products = products;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }
}