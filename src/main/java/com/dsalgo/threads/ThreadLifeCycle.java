package com.dsalgo.threads;


/**
 * Whenever the thread is created the state was NEW
 * After whenever we call the start method the state goes to RUNNABLE
 * When we call Sleep then thread state was TIMED_WAITING
 * Once the thread job is completed then thread state is TERMINATED
 */
public class ThreadLifeCycle extends Thread{

    @Override
    public void run() {

        System.out.println("Thread is running");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Wake up after sleep");
    }


    public static void main(String[] args) {

        ThreadLifeCycle threadLifeCycle=new ThreadLifeCycle();
        System.out.println("Thread state after creation :"+threadLifeCycle.getState());

        threadLifeCycle.start();
        System.out.println("Thread state after calling start :"+threadLifeCycle.getState());

        try{
            threadLifeCycle.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Thread state after completion :"+threadLifeCycle.getState());

    }
}
