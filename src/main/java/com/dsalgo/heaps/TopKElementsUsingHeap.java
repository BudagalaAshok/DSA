package com.dsalgo.heaps;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.PriorityQueue;

public class TopKElementsUsingHeap {


    /**
     * First step is finding the frequency of each element and put  in to hash map
     * second step is push to priority queue with less frequency first
     * Now if the priority size is greater than k then remove the first element from the priorty queue
     * @param arr
     * @param k
     */
    public static void printTopKFrequentElements(int[] arr, int k){

        Map<Integer,Integer> integerMap= Maps.newHashMap();
        for (int element:arr){
            integerMap.put(element,integerMap.getOrDefault(element,0)+1);
        }

        //Now Define a Priority Queue with MinHeap of Lowest frequent elements as top
        PriorityQueue<Map.Entry<Integer,Integer>> priorityQueue=new PriorityQueue<>((o1, o2) -> o1.getValue()-o2.getValue());

        //Now insert element into heap based on their frequency
        for (Map.Entry<Integer,Integer> entry:integerMap.entrySet()){

            priorityQueue.add(entry);
            if(priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }

        while (!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll().getKey());
        }

    }

    public static void main(String[] args) {

        int[] arr={1,1,1,2,2,3};
        int k=2;
        printTopKFrequentElements(arr,k);

    }

}
