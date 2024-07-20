package com.dsalgo.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfRunningDataStream {


    private PriorityQueue<Integer> leftMax;
    private PriorityQueue<Integer> rightMin;


    public MedianOfRunningDataStream() {
        leftMax=new PriorityQueue<>(Collections.reverseOrder());
        rightMin =new PriorityQueue<>();
    }

    public void add(int num){

        if(leftMax.isEmpty() || num<=leftMax.peek()){
            leftMax.offer(num);
        }else{
            rightMin.offer(num);
        }

        //Balancing heaps at most the difference should be one
        //If left heap size is greater than right heap size +1 then move the left top element to right
        if(leftMax.size()>rightMin.size()+1){
            rightMin.offer(leftMax.poll());
        }else if(rightMin.size()>leftMax.size()){
            //If right heap is greater than left heap then move the first right top element to left
            leftMax.offer(rightMin.poll());
        }

    }

    public double findMedian(){

        //If both sizes are equal then avg of both first elements
        if(leftMax.size()==rightMin.size()){
            return (leftMax.peek()+rightMin.peek())/2.0;

        }else{
            //If not median is root of the larger heap
            return leftMax.peek();
        }


    }

    public static void main(String[] args) {
        MedianOfRunningDataStream runningDataStream=new MedianOfRunningDataStream();
        runningDataStream.add(5);
        runningDataStream.add(1);
        System.out.println(runningDataStream.findMedian());

    }


}
