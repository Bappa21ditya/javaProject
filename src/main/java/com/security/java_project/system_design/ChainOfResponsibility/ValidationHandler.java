package com.security.java_project.system_design.ChainOfResponsibility;

public class ValidationHandler extends Handler {

    @Override
    public void handle(Request request) {

        System.out.println("Validation successful");

        if(next != null)
            next.handle(request);

    }
}
