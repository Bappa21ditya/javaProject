package com.security.java_project.system_design.TemplatePattern;

public class TemplatePatternApplicationMain {

    // we need call using parent class variable so it can call method present inside prepare,
    //why prepare is final so no one can implement and modify it
    public static void main(String[] args) {
       Beverage beverage=new Tea();
       beverage.prepare();

        Beverage beverage1=new Tea();
        beverage1.prepare();

    }
}
