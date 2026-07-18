package com.security.java_project.threading.monitorlock;

public class MythreadMain {

    public static void main(String[] args) {

        MyclassMnitorLock obj = new MyclassMnitorLock();

        // older way 1, implement runnable interface then pass this runnable object to thread

//        class Task1Runner implements Runnable {
//            private MyclassMnitorLock obj;
//
//            Task1Runner(MyclassMnitorLock obj) {
//                this.obj = obj;
//            }
//
//            public void run() {
//                obj.task1();
//            }
//        }

      //  Thread t1 = new Thread(new Task1Runner(obj));

// older way 2, implement runnable interface in side the thread class to pass runnable object to thread
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                obj.task1();
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                obj.task2();
//            }
//        });

        // using lambda we can implement runnable directly, runnable interface is already present,so just implement it using lambda

        Thread t1 = new Thread(() -> {
            obj.task1();
        });

        Thread t2 = new Thread(() -> obj.task2());

        Thread t3 = new Thread(() -> obj.task3());

        t1.start();
        t2.start();
        t3.start();
    }
}
