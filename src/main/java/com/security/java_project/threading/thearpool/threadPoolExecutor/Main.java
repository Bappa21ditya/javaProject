package com.security.java_project.threading.thearpool.threadPoolExecutor;

import java.util.concurrent.*;

public class Main {

    public static void main(String args[]) {

//        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(2,4,1, TimeUnit.MINUTES,
//                new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 1, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2), new CustomThreadFactory(), new CustomRejectHandler());

        for(int i=1;i<=7;i++)
        {
            threadPoolExecutor.submit( ()->{
                  try{
                       Thread.sleep(5000);
                 } catch (Exception ex) {
                  }
           System.out.println("Task Processed By :"+Thread.currentThread().getName());
       }   );


           }

    }
}


    class CustomThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread th = new Thread(r);
            th.setPriority(Thread.NORM_PRIORITY);
            th.setDaemon(false);
            return th;
        }
    }

    class CustomRejectHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("Task Rejected :" + r.toString());
        }
    }

