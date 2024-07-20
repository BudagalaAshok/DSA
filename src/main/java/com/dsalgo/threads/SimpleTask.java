package com.dsalgo.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleTask implements Runnable{

    private final String taskName;

    public SimpleTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName+" is being executed by :"+Thread.currentThread().getName());
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //A group of pre-instantiated reusable threads that are used to execute tasks. Using thread pools improves performance and resource management by reusing threads for multiple tasks.
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            SimpleTask task=new SimpleTask("task"+i);
            //Here we are passing Runnable
            executorService.execute(task);

        }
        executorService.shutdown();
    }
}
