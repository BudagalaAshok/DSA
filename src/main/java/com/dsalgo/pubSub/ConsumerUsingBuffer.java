package com.dsalgo.pubSub;

public class ConsumerUsingBuffer implements Runnable{

    private final Buffer buffer;

    public ConsumerUsingBuffer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true){
            try {
                int value=buffer.take();
                System.out.println("Consumer value is :"+value);
                if(value==-1){
                    buffer.put(-1);
                    break;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }
}
