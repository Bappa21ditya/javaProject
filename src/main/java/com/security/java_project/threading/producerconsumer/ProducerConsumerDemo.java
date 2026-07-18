package com.security.java_project.threading.producerconsumer;

public class ProducerConsumerDemo {
    public static  void main(String args[]){

    Buffer buffer=new Buffer();

    Thread producer =new Thread( ()-> {
    int value = 0;

        try {
            while (true) {
                buffer.produce(value++);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    );

    Thread consumer=new Thread(()->{

            try {
                while (true) {
                    buffer.consume();
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    });

    producer.start();
    consumer.start();
}
            }

   // sleep is present out side lock...
//What actually happens step by step
//🟢 Step 1: Producer enters produce()
//Acquires lock
//Adds item
//Calls notify()
//Exits method → releases lock
//🟡 Step 2: Now producer goes to sleep
//Thread.sleep(500);
//
//👉 At this point:
//
//Producer is sleeping 😴
//BUT lock is already released
//🟢 Step 3: Consumer runs
//Consumer acquires lock
//Consumes item
//Calls notify()
//🔥 Key insight
//
//👉 sleep() does NOT block other threads because it's outside synchronized block
//
//⚠️ What if sleep was inside synchronized?
//public synchronized void produce(int value) {
//    Thread.sleep(500); // ❌ BAD
//}
//
//👉 Now:
//
//Producer holds lock while sleeping
//Consumer CANNOT run ❌