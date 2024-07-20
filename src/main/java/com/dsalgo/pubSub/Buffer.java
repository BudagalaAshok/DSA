package com.dsalgo.pubSub;

import java.util.LinkedList;
import java.util.Queue;

public class Buffer {

    private final Queue<Integer> queue=new LinkedList<>();
    private final int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(int value) throws InterruptedException {

        if(queue.size()==capacity){
            wait(); // If queue at full capacity we need to wait
        }
        queue.offer(value); //Notify consumer an item is pushed
        notifyAll();

    }

    public synchronized int take() throws InterruptedException {
        if (queue.isEmpty()){
            wait(); //If queue is empty need to wait until any item got added
        }
        int value=queue.poll();
        notifyAll();//Notify producers that space is available
        return value;

    }

}
