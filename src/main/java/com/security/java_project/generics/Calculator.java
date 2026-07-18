package com.security.java_project.generics;

public class Calculator <T extends  Number>{

    public  double add(T a,T b) {
        return a.doubleValue()+b.doubleValue();
    }
}
