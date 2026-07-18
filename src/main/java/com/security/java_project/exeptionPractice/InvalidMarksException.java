package com.security.java_project.exeptionPractice;

public class InvalidMarksException extends RuntimeException{
    public InvalidMarksException(String message) {
        super(message);
    }
}
