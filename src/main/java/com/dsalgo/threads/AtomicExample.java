package com.dsalgo.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample {
    private static final int THREAD_COUNT = 10;
    private static final int INCREMENT_COUNT = 1000;
    private static AtomicInteger atomicCounter = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];

        // Create and start threads
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new CounterIncrementer());
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < THREAD_COUNT; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print the final value of the counter
        System.out.println("Final counter value: " + atomicCounter.get());
    }

    static class CounterIncrementer implements Runnable {
        @Override
        public void run() {
            System.out.println("Running a Thread with name :"+Thread.currentThread().getName());
            for (int i = 0; i < INCREMENT_COUNT; i++) {
                atomicCounter.incrementAndGet();
            }
        }
    }
}

