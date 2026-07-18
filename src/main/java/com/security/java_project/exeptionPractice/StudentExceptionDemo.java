package com.security.java_project.exeptionPractice;

public class StudentExceptionDemo {
    public static void main(String args[])
    {
       try {
           Student student = new Student("jr", 120);
           student.display();
       }
       catch (InvalidMarksException e)
       {
           System.out.println("Exception caught: " + e.getMessage());
       }
        System.out.println("Program continues...");

    }
}
