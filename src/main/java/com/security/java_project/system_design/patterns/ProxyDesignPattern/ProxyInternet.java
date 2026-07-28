package com.security.java_project.system_design.patterns.ProxyDesignPattern;

public class ProxyInternet implements Internet{

    RealInternet realInternet=new RealInternet();
    @Override
    public void connect(String website) {
        if (website.equals("facebook.com"))
        {
            System.out.println("Access Denied");
            return;
        }
        realInternet.connect(website);

    }
}
