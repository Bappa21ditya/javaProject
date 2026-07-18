package com.security.java_project.exception;

import java.sql.SQLOutput;

public class mango {

    public static void getMapping() {
        try {
            throw new ClassCastException();
            } catch (ClassCastException classCastException) {
            classCastException.printStackTrace();
           }
       }
        public static void main (String args[])
        {
            System.out.println("this is inside main method");
            getMapping();
        }
    }

