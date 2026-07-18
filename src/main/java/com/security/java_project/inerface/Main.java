package com.security.java_project.inerface;

public class Main {
    public static void main(String args[])
    {
        Dog d1=new Dog();
        d1.eat();
        Animal a1= new Dog();
        d1.eat();
        d1.run();
        Animal.hunting();


    }
}
