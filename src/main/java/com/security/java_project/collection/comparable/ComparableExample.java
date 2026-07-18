package com.security.java_project.collection.comparable;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class ComparableExample {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(3, "B"));
        list.add(new Employee(1, "A"));
        list.add(new Employee(2, "C"));

        sort(list);
        System.out.println("Sorted by ID (Comparable): " + list);;
    }
}
