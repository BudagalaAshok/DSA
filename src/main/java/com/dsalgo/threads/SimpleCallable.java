package com.dsalgo.threads;

import java.util.concurrent.*;

//Callable is same as runnable it can return a result and throw a checked exception
public class SimpleCallable implements Callable<Integer> {
    private final int number;

    public SimpleCallable(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 0; i < number; i++) {
            sum+=i;
        }
        return sum;
    }

    public static void main(String[] args) {
        //A framework that simplifies managing a pool of threads, allowing you to run tasks asynchronously without manually creating and managing thread objects.
        ExecutorService executorService=Executors.newSingleThreadExecutor();
        SimpleCallable callable=new SimpleCallable(10);
        // Represents the result of an asynchronous computation. It provides methods to check if the computation is complete,
        // to wait for its completion, and to retrieve the result.
        Future<Integer> future=executorService.submit(callable);
        try {
            System.out.println("Sum of first 10 numbers:"+future.get());
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
    }
}
