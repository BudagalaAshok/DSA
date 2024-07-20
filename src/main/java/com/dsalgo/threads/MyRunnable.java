package com.dsalgo.threads;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("In run method");
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyRunnable runnable=new MyRunnable();
        Thread thread=new Thread(runnable);
        thread.start();
    }
}
