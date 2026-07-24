package com.security.java_project.system_design.builderPattern;

public class BuilderPatternApplicationMain {
    public static void main(String[] args) {

        User user = User.builder()
                .name("Bappa")
                .age(27)
                .email("bappa@gmail.com")
                .build();

        System.out.println(user);
    }
}
