package com.example.baitap.repository;

import com.example.baitap.entity.Customer;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CustomerRepository {
    private final Map<Long, Customer> store = new ConcurrentHashMap<>();

    public Customer save(Customer customer) {
        store.put(customer.getId(), customer);
        return customer;
    }

    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Customer> findAll() {
        return new ArrayList<>(store.values());
    }
}