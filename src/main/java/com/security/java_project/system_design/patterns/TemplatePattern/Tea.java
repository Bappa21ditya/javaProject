package com.security.java_project.system_design.patterns.TemplatePattern;

public class Tea extends Beverage{
    @Override
    protected void brew() {
        System.out.println("Adding Tea Leaves");
    }
}
