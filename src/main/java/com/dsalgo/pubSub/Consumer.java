package com.dsalgo.pubSub;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            while (true){
                Integer value=queue.take();
                if(value==-1){
                    queue.put(-1);
                    break;
                }
                System.out.println("Consumed value is :"+value);
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
