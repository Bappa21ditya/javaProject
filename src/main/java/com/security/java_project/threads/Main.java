package com.security.java_project.threads;




class Counter
{
   private int count=0;

    public synchronized void  increment()
    {
        count++;
    }

    public int getCount()
    {
        return count;
    }

}

class MyRunnale implements Runnable
{

    @Override
    public void run() {
        System.out.println("2.this is inside runnable interface-----");
    }
}


public class Main {


    public static void main(String agrs[]) throws InterruptedException {

        // Counter counter=new Counter();
//        Cat c1 = new Cat();
//        c1.start();


//        Thread t1 = new Thread(
//                ()->{ for(int i=0;i<1000;i++) counter.increment();
//                });
//
//        Thread t2 = new Thread(
//                ()->{ for(int i=0;i<1000;i++) counter.increment();
//                });
//
//
//        t1.start();
//        t2.start();
//        t1.join(); t2.join();
        // t1.join(); t2.join();

        //  System.out.println("Final Count: " + counter.getCount());
      //  Cat cat = () -> System.out.println("this is inside run method");

        // Calling the run method
       // cat.run();


    }
}