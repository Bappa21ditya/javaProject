package com.security.java_project.system_design.DecoratorPattern;

public abstract class CoffeeDecorator implements  Coffee{

    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
