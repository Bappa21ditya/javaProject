package com.security.java_project.inerface;

public interface Animal {

    void eat();

    static  void hunting()
    {
        System.out.println("animal is build for hunting");
    }

    default  void run()
    {
        System.out.println("this animal can run");
    }
}
