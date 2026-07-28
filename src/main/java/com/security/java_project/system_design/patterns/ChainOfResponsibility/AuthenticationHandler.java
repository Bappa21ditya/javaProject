package com.security.java_project.system_design.patterns.ChainOfResponsibility;

public class AuthenticationHandler extends Handler {

    @Override
    public void handle(Request request) {

        System.out.println("Authentication successful");

        if(next != null)
            next.handle(request);

    }
}
