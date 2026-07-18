package com.security.java_project.generics;

public class Print <T>{

    T key;

   void setPrint(T key)
    {
        this.key=key;
    }

   T getPrint()
    {
        return key;
    }
}
