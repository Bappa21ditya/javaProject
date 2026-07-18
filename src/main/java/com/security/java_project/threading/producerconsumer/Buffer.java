package com.security.java_project.threading.producerconsumer;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Buffer {
     private Queue<Integer> queue =new LinkedList<>();
     private final int capacity=5;

    public  synchronized void produce(int value) throws InterruptedException {
      //  wait() → releases lock, allows consumer to run
      //  notify() → wakes waiting thread

        if(queue.size()==capacity)
        {
            System.out.println("Thread : " + Thread.currentThread().getName() + " is waiting now");
            System.out.println("Buffer is full, producer waiting...");
            wait();
        }

        queue.add(value);
        System.out.println("Produced: " + value);
        System.out.println("Item produced  by: "+Thread.currentThread().getName());

        // Notify consumer that new data is available
        notify();

    }
    public synchronized void  consume() throws InterruptedException {
        while(queue.isEmpty())
        {
            System.out.println("Thread : " + Thread.currentThread().getName() + " consumer thread is wwaiting");
            System.out.println("Buffer is empty, consumer waiting...");
        wait();
        }
       int value=queue.poll();
        System.out.println("Consumed: " + value);
        System.out.println("Item consumed by: "+Thread.currentThread().getName());
        // Notify producer that space is available
        notify();

    }
}

//Real sequence
//Thread A → calls wait() → releases lock
//Thread B → enters → calls notify()
//Thread A → becomes ready (not running yet)
//Thread B → exits synchronized block → releases lock
//Thread A → acquires lock → continues
//🚀 Simple analogy
//wait() → “I’ll step out, someone else can work”
//notify() → “Hey, someone can come back now”
//Lock release → “Door is actually open now”
//

//Producer sleeps 500 ms
//Consumer sleeps 10 ms
//producer → slower
//consumer → faster
//🧠 What actually happens
//Step-by-step:
//Producer runs
//Enters produce() (synchronized)
//Adds item
//Exits → lock released
//Producer goes to sleep (500 ms) 😴
//👉 Important: lock is already released
//Consumer runs
//Enters consume() (gets lock)
//Removes item
//Exits → lock released
//Consumer sleeps only 10 ms
//Consumer wakes up again quickly
//👉 Tries to run consume() again
//🔥 Your key question
//
//“Will consumer run again while producer is sleeping?”
//
//👉 ✅ YES — absolutely
//
//Because:
//
//Producer is sleeping (not holding lock)
//Consumer wakes up faster
//Lock is free → consumer keeps running
//⚠️ But there is a catch
//
//If consumer runs too fast:
//
//if(queue.isEmpty()) {
//    wait();
//}
//
//👉 Then:
//
//Consumer finds buffer empty ❌
//Calls wait()
//Goes into waiting state
//⚙️ So real behavior becomes
//Case 1: Buffer has data
//
//👉 Consumer keeps consuming repeatedly ✅
//
//Case 2: Buffer becomes empty
//
//👉 Consumer goes into wait() ⛔
//👉 Waits for producer notify()
//
//🔄 Final execution pattern
//Producer produces slowly (every 500ms)
//Consumer tries frequently (every 10ms)
//Consumer:
//Consumes available data
//Then waits when empty


