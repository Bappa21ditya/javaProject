package com.security.java_project.system_design.patterns.DecoratorPattern;

public class SugarDecorator extends CoffeeDecorator{

    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return coffee.description() + " + Sugar";
    }

    @Override
    public double cost() {
        return coffee.cost() + 1;
    }
}
