package com.dsalgo.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Provide more extensive locking operations than synchronized methods and blocks. They offer methods to acquire and release locks.
public class ReEntrantLockExample {

    private int count = 0;
    private Lock lock = new ReentrantLock();

    public void incrementCount() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }

    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {

        ReEntrantLockExample reEntrantLockExample = new ReEntrantLockExample();
        Runnable task = () -> {
            for (int i = 0; i < 1000; i++) {
                reEntrantLockExample.incrementCount();
            }
        };
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final count was :" + reEntrantLockExample.getCount());


    }


}
