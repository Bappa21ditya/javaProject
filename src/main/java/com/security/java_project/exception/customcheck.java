package com.security.java_project.exception;

public class customcheck {

    public static  void method1() throws MyCustomException
    {
        throw  new MyCustomException("this is my exceptions class");
    }

    public static void main(String args[]) {
        try {
            method1();
        }catch (MyCustomException exception)
        {
            System.out.println(exception.getMessage());
        }
    }
}
