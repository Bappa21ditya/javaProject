package com.security.java_project.inerface.functional_interfrace;

public class Test {

    public static void main(String args[]) {
        //      Animal a= (cat)->{
        //      System.out.println(" this is cat");
        //   };
        //     a.eat("fish");

        Add obj = (int a, int b) -> {
            System.out.println(a + b);
        };
        obj.add(10,20);
    }


}
