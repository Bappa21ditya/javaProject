package com.security.java_project.system_design.ProxyDesignPattern;

public class ProxyDesignPatternApplicationMain {

    public static void main(String[] args) {

        Internet internet=new ProxyInternet();
        internet.connect("google.com");
        internet.connect("facebook.com");
    }
}
