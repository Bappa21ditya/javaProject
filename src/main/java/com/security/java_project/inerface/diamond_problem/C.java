package com.security.java_project.inerface.diamond_problem;

public class C implements A,B{

    ///  normally don't need to implement default method but  here both are same so
    ///  compiler will  bbe confused which default method should be implemented so use override method
    @Override
    public void cum() {
        A.super.cum();
    //    System.out.println("TGIS IS INSIDE C CLASS");
    }

}
