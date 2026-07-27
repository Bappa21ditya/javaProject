package com.security.java_project.system_design.ProxyDesignPattern;

public class RealInternet implements Internet{

    @Override
    public void connect(String website)
    {
        System.out.println("Connecting to " + website);
    }
}
