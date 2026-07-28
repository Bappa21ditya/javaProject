package com.security.java_project.system_design.patterns.factory;

public class Bike implements Vehicle{
    @Override
    public void drive() {
        System.out.println("this is bike class");
    }
}
