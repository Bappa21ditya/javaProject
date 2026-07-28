package com.security.java_project.system_design.patterns.ChainOfResponsibility;

public class LoggingHandler extends Handler{

    @Override
    public void handle(Request request) {

        System.out.println("Logging request");

        if(next != null)
            next.handle(request);

    }
}
