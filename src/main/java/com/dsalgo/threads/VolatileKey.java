package com.dsalgo.threads;


/*
  Using volatile keyword the variable value we can share with multiple threads if any one of the thread change the value of variable
  automatically another variable uses that changed value
 */
public class VolatileKey {

    private volatile boolean running=true;
    public void run() {
        System.out.println("Thread started");
        while (running){

        }
        System.out.println("Thread stopped");
    }

    public void stopRunning(){
        running=false;
    }

    public static void main(String[] args) {
        VolatileKey volatileKey=new VolatileKey();
        Thread thread=new Thread(volatileKey::run);
        thread.start();
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        //Main thread changed the value
        volatileKey.stopRunning();

        try {
            //Used to stops its execution and the thread goes in to the dead state,it waits until the thread is dead
            thread.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Main Thread Finished");
    }

}
