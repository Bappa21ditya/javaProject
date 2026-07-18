package com.security.java_project.system_design.strategyPattern;

public class Card implements Strategy{
    public void pay() {
        System.out.println("Pay using Card");
    }
}
