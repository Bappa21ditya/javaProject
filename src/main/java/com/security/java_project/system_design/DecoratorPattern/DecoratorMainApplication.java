package com.security.java_project.system_design.DecoratorPattern;

public class DecoratorMainApplication {


    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();

        coffee = new MilkDecorator(coffee);

        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.description());

        System.out.println(coffee.cost());

    }
}
