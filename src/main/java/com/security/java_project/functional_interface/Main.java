package com.security.java_project.functional_interface;

public class Main {

    public static void main(String agrs[]) {
        Parroat p1 = new Parroat();
        p1.fly(2);

        Bird b1 = new Bird() {
            @Override
            public void fly(int wings) {
                System.out.println(wings);
            }
        };
        b1.fly(4);


        Bird b2 = (int wings) -> {
            System.out.println(wings);
        };
        b2.fly(6);
    }
}
