package com.security.java_project.collection.comparator;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return Double.compare(o1.salary, o2.salary);
    }
}
