package com.security.java_project.threading.shreadResources;

public class SharedResorcesMainClass {

    public static void main(String[] args) {

        SharedResouces sharedResouces = new SharedResouces();

        Thread producerThread = new Thread(() -> {
            System.out.println("Producer Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            sharedResouces.addItem();
        });

        Thread consumerThread = new Thread(() -> {
            System.out.println("Consumer Thread: " + Thread.currentThread().getName());
            sharedResouces.consumeItem();
        });

        producerThread.start();
        consumerThread.start();
    }



}
