package com.security.java_project.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExectorServiceDemo {
    public static void main(String args[]) throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            int taskId = i;
//            executorService.submit(()->{
//                System.out.println("Task " + taskId +
//                        " executed by " + Thread.currentThread().getName());
//            });
            Callable<String> task = () -> {
                return "Task " + taskId +
                        " executed by " + Thread.currentThread().getName();
            };

            Future<String> future = executorService.submit(task);

            // get result from callable
            String result = future.get();
            System.out.println(result);
        }


        executorService.shutdown();

    }
}

