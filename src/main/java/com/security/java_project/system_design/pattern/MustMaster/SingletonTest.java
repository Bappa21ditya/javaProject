package com.security.java_project.system_design.pattern.MustMaster;

public class SingletonTest {
    public static void main(String[] args) {
        Runnable task = () -> {

            com.security.java_project.system_design.pattern.MustMaster.DoubleLocking singleton= com.security.java_project.system_design.pattern.MustMaster.DoubleLocking.getDoubleLockingInstance();

            System.out.println(
                    Thread.currentThread().getName()
                            + " -> HashCode: "
                            + singleton.hashCode()
            );


        };
        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");
        Thread t3 = new Thread(task, "Thread-3");

        t1.start();
        t2.start();
        t3.start();
    }
}
