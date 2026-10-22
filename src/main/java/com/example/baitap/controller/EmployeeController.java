package com.example.baitap.controller;

import com.example.baitap.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//bài 8
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    // Giả lập dữ liệu có sẵn nhân viên ID = 1
    private final Map<Long, Employee> employeeDb = Map.of(
            1L, new Employee(1L, "Nguyen Van A", "IT")
    );

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployee(@PathVariable("id") Long id) {
        Employee emp = employeeDb.get(id);

        // Nếu không tìm thấy, trả về ngay Map lỗi kèm HTTP 404
        if (emp == null) {
            Map<String, Object> error = Map.of(
                    "error", "Employee not found",
                    "status", 404
            );
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }

        // Tìm thấy thì trả về thông tin nhân viên kèm HTTP 200
        return ResponseEntity.ok(emp);
    }
}