package com.security.java_project.exeptionPractice;

public class Student {
    String name;
    int marks;



    public Student(String name, int marks) {
        this.name = name;
        setMarks(marks);


    }

    public void setMarks(int marks) {
        if(marks<0 || marks>100)
        {
            throw new InvalidMarksException("Marks must be between 0 and 100");
        }
        this.marks = marks;
    }

    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
    }
}
