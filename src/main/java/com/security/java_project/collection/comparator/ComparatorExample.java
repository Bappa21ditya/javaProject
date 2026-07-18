package com.security.java_project.collection.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(3, "B", 50000));
        list.add(new Employee(1, "A", 70000));
        list.add(new Employee(2, "C", 60000));

        Collections.sort(list,new SalaryComparator());
        System.out.println("Sorted by Salary (Comparator): " + list);

    }
    }
