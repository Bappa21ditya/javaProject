package com.security.java_project.system_design.observerpattern;

public class User implements Observer{
    private String name;

     User(String name)
    {
        this.name=name;
    }


    @Override
    public void update(String message) {
        System.out.println(name + " received: " + message);
    }
}
