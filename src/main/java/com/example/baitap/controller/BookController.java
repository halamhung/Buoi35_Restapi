package com.example.baitap.controller;

import com.example.baitap.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//bai 7
@RestController
@RequestMapping("/books")
public class BookController {

    private final List<Book> books = List.of(
            new Book(1L, "day nau an", "golden ramsay"),
            new Book(2L, "dac nhan tam", "khong biet"),
            new Book(3L, "kinh thanh", "Jesus")
    );

    @GetMapping("/search")
    public List<Book> searchByAuthor(@RequestParam("author") String author) {
        return books.stream()
                .filter(b -> b.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .toList();
    }
}