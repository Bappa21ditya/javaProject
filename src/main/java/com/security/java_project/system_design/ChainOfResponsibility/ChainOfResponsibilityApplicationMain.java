package com.security.java_project.system_design.ChainOfResponsibility;

public class ChainOfResponsibilityApplicationMain {

    public static void main(String[] args) {

        Handler auth = new AuthenticationHandler();
        Handler log = new LoggingHandler();
        Handler validation = new ValidationHandler();

        auth.setNext(log)
                .setNext(validation);

        auth.handle(new Request());

    }
}
