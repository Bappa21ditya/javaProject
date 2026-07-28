package com.security.java_project.system_design.ChainOfResponsibility;

public abstract class Handler {

    protected Handler next;

    public Handler setNext(Handler next) {
        this.next = next;
        return next;
    }

    public abstract void handle(Request request);
}
