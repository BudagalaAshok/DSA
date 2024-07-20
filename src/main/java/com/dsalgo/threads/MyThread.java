package com.dsalgo.threads;

public class MyThread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Thread using Thread class :"+i);
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        myThread.start();
    }
}
