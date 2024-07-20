package com.dsalgo.threads;

public class Counter {

    private int counter=0;

    //Synchronized method to increment counter value
    public synchronized void incrementCounter(){
        //System.out.println(Thread.currentThread().getName());
        counter++;
    }

    //Instead of putting the whole method we can put a particular piece of code block under synchronization
    public void incrementPieceOfCounter(){
        synchronized (this) {
            counter++;
        }
    }

    public int getCounter(){
        return counter;
    }

    public static void main(String[] args) {

        Counter counter=new Counter();

        Thread t1=new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.incrementCounter();

            }
        });

        Thread t2=new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                counter.incrementCounter();
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println("Final count :"+counter.getCounter());



    }



}
