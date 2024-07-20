package com.dsalgo.threads;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//ReadWriteLock: A lock that allows multiple readers to access a resource simultaneously, but only one writer can modify it at a time.
// This improves performance for read-heavy operations.
public class ReadWriteLockExample {

    private int count;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void incrementWriteCount() {
        lock.writeLock().lock();
        try {
            count++;
        } finally {
            lock.writeLock().unlock();
        }
    }

    public int getCount() {
        lock.readLock().lock();
        try {
           return count;
        } finally {
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReadWriteLockExample readWriteLockExample=new ReadWriteLockExample();
        Runnable writeLock = () -> {
            for (int i = 0; i < 1000; i++) {
                readWriteLockExample.incrementWriteCount();
            }
        };

        Runnable readLock = () -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println(readWriteLockExample.getCount());
                readWriteLockExample.getCount();
            }
        };

        Thread t1 = new Thread(writeLock);
        Thread t2 = new Thread(readLock);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final count was :" + readWriteLockExample.getCount());
    }

}
