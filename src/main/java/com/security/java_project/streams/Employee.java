package com.security.java_project.streams;

import java.util.Arrays;
import java.util.List;

public class Employee {
    private int id;
    private String name;
    private int age;
    private double salary;
    private String department;
    private String gender;

    // Constructor
    public Employee(int id, String name, int age, double salary, String department, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
        this.gender = gender;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }
    public String getDepartment() { return department; }
    public String getGender() { return gender; }

    // toString() for easy printing
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    // Helper method to create a sample list for practice
    public static List<Employee> getEmployeeList() {
        return Arrays.asList(
                new Employee(1, "Alice", 30, 75000.0, "IT", "Female"),
                new Employee(2, "Bob", 28, 62000.0, "HR", "Male"),
                new Employee(3, "Charlie", 35, 90000.0, "IT", "Male"),
                new Employee(4, "Diana", 40, 110000.0, "Finance", "Female"),
                new Employee(5, "Ethan", 25, 50000.0, "HR", "Male"),
                new Employee(6, "Fiona", 32, 82000.0, "Finance", "Female"),
                new Employee(7, "George", 45, 120000.0, "IT", "Male"),
                new Employee(8, "Hannah", 29, 68000.0, "HR", "Female"),
                new Employee(9, "Ian", 38, 95000.0, "Finance", "Male"),
                new Employee(10, "Julia", 26, 55000.0, "IT", "Female")
        );
    }
}
