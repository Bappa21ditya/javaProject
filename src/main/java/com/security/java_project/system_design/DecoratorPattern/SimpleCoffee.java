package com.security.java_project.system_design.DecoratorPattern;

public class SimpleCoffee implements Coffee{

    @Override
    public String description() {
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        return 5;
    }
}
