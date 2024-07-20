package com.dsalgo.pubSub;

public class ProducerUsingBuffer implements Runnable {

    private final Buffer buffer;

    public ProducerUsingBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try{
            for (int i = 0; i < 10; i++) {
                buffer.put(i);
                System.out.println("Produced value :"+i);
            }
            buffer.put(-1);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
