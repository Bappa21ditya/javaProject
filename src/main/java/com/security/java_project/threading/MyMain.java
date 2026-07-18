package com.security.java_project.threading;

public class MyMain {
    public static void main(String args[]) {
        MyThread myThread = new MyThread();
        Thread t1=new Thread(myThread);
        t1.start();

        MyThreadClass myThreadClass=new MyThreadClass();
        myThreadClass.start();

        Thread t3= new Thread(()-> System.out.println("this is inside child class"));
        t3.start();
    }

}
