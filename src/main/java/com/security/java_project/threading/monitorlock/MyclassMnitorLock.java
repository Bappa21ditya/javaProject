package com.security.java_project.threading.monitorlock;

public class MyclassMnitorLock {

   public synchronized void  task1()
    {

        try {
            System.out.println("this is task1");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  void task2()
    {
        System.out.println("this is task2 before synchronized");

        synchronized (this)
        {
            System.out.println("this is task2  after synchronized");
        }

    }

    public void task3()
    {
        System.out.println("this is task 3");
    }
}
