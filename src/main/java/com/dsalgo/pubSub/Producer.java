package com.dsalgo.pubSub;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    private final BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i < 5; i++) {
                queue.put(i);
                System.out.println("Produced :"+i);
            }
            queue.put(-1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
