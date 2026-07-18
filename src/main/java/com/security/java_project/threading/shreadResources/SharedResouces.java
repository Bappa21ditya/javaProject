package com.security.java_project.threading.shreadResources;

public class SharedResouces {

    boolean itemAvailable=false;

    public synchronized void addItem()
    {
     itemAvailable=true;
        System.out.println("Item added by: "+Thread.currentThread().getName()+" and invoking all the threads that's are awaiting");
        notify();
    }

    public synchronized void consumeItem()
    {

       while(!itemAvailable) {
           try {
               System.out.println("Thread : " + Thread.currentThread().getName() + " is waiting now");
              wait();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
           System.out.println("Item consumed by: "+Thread.currentThread().getName());

           itemAvailable=false;


    }
}


