package com.security.java_project.system_design.patterns.TemplatePattern;

public abstract class Beverage {

    public final void prepare() {

        boilWater();

        brew();

        pourIntoCup();

        serve();

    }

    private void boilWater() {
        System.out.println("Boiling Water");
    }

    private void pourIntoCup() {
        System.out.println("Pouring into Cup");
    }

    private void serve() {
        System.out.println("Serving");
    }

    protected abstract void brew();
}
