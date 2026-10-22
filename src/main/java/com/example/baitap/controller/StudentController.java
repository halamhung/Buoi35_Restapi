package com.example.baitap.controller;

import com.example.baitap.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//bài 5
@RestController
@RequestMapping("/students")
public class StudentController {

    private final Map<Long, Student> studentDb = new ConcurrentHashMap<>();

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        studentDb.put(student.getId(), student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
        Student student = studentDb.get(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }
}