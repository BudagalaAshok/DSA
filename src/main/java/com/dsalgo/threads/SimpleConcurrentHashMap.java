package com.dsalgo.threads;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleConcurrentHashMap {

    public static void main(String[] args) {
        //A thread-safe version of HashMap that allows concurrent access and updates to the map without locking the entire collection.
        // This increases performance when multiple threads are reading and writing to the map.
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        Runnable writeTask = () -> {

            for (int i = 0; i < 5; i++) {
                map.put("Key " + i, i);
                System.out.println("Adding key with " + i);
            }

        };

        Runnable readTask = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Reading value with key :" + map.get("Key " + i));

            }
        };
        Thread writeThread = new Thread(writeTask);
        Thread readThread = new Thread(readTask);

        writeThread.start();
        readThread.start();
        try {
            writeThread.join();
            readThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Final Map is :" + map);
    }

}
