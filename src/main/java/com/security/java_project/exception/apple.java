package com.security.java_project.exception;

import java.sql.SQLOutput;

public class apple {

    void checkError() throws RuntimeException {
        try {
            throw new ArithmeticException();
        }
        finally {
        System.out.println("under flow");
        }
    }
    public static  void main(String[] args) throws RuntimeException
    {
        apple a1=new apple();
        a1.checkError();
    }

}
