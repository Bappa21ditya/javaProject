package com.security.java_project.collection.comparable;

public class Employee implements Comparable<Employee>{

    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - " + name;
    }
    @Override
    public int compareTo(Employee other) {
        return this.id-other.id;
    }
}
