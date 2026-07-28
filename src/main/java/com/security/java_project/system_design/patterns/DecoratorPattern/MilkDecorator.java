package com.security.java_project.system_design.patterns.DecoratorPattern;

public class MilkDecorator extends CoffeeDecorator{

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String description() {
        return coffee.description() + " + Milk";
    }

    @Override
    public double cost() {
        return coffee.cost() + 2;
    }
}
