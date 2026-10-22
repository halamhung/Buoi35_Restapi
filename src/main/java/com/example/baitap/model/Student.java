package com.example.baitap.model;

public class Student {
    private Long id;
    private String name;
    private int age;
    private String major;

    public Student() {}

    public Student(Long id, String name, int age, String major) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getMajor() { return major; }
    public void setMajor(String major) { this.major = major; }
}