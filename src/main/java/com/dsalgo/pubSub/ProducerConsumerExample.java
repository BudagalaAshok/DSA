package com.dsalgo.pubSub;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerExample {

    public static void main(String[] args) {



        Buffer buffer=new Buffer(5);

        //method using explicitly synchronized block with wait(), notifyAll()

        ProducerUsingBuffer producerBuffer=new ProducerUsingBuffer(buffer);
        ConsumerUsingBuffer consumerBuffer1=new ConsumerUsingBuffer(buffer);
        ConsumerUsingBuffer consumerBuffer2=new ConsumerUsingBuffer(buffer);

        Thread producerBufferThread=new Thread(producerBuffer);
        Thread consumerBufferThread1=new Thread(consumerBuffer1);
        Thread consumerBufferThread2=new Thread(consumerBuffer2);

        producerBufferThread.start();
        consumerBufferThread1.start();
        consumerBufferThread2.start();

        //Using Block Queue it handles synchronization internally and we no need to notify or wait it all do internally
        BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(5);

        Producer producer=new Producer(queue);
        Consumer consumer1=new Consumer(queue);
        Consumer consumer2=new Consumer(queue);

        //Using Thread Framework
        Thread producerThread=new Thread(producer);
        Thread consumerThread1=new Thread(consumer1);
        Thread consumerThread2=new Thread(consumer2);

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();

        //Using Executor Framework, It looks clean compared to Thread framework, Instead of creating thread separately for producer and consumer
        //Here using thread pool to create threads
        ExecutorService executorService= Executors.newFixedThreadPool(3);
        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        executorService.shutdown();



    }

}
