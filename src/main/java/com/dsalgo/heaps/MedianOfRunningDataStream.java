package com.dsalgo.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfRunningDataStream {


    //LeftMaxHeap (max-heap): Stores the smaller half of the numbers.
    private PriorityQueue<Integer> leftMax;

    //RightMinHeap (min-heap): Stores the larger half of the numbers.
    private PriorityQueue<Integer> rightMin;


    public MedianOfRunningDataStream() {
        leftMax = new PriorityQueue<>(Collections.reverseOrder());
        rightMin = new PriorityQueue<>();
    }

    public void add(int num) {


        /**
         * Why Push into LeftMaxHeap When Current Value < LeftMaxHeap.peek()?
         *
         * 	•	The leftMaxHeap stores the smaller half of the numbers, which means the largest number in this heap (its root, peek() value) is still smaller than or equal to the median.
         * 	•	If the current number is smaller than the largest number in the leftMaxHeap, it naturally belongs in the smaller half of the data, i.e., it should be placed in the leftMaxHeap.
         * 	•	This ensures that all the smaller numbers (less than or equal to the median) are stored in the leftMaxHeap, keeping the heaps correctly partitioned.
         *
         * Process of Insertion:
         *
         * 	1.	New number is smaller than the top of leftMaxHeap (leftMaxHeap.peek()):
         * 	•	It belongs to the smaller half of the data, so push it into the leftMaxHeap.
         * 	2.	New number is larger than or equal to the top of leftMaxHeap:
         * 	•	It belongs to the larger half of the data, so push it into the rightMinHeap.
         */

        if (leftMax.isEmpty() || num <= leftMax.peek()) {
            leftMax.offer(num);
        } else {
            rightMin.offer(num);
        }

        //Balancing heaps at most the difference should be one
        //If left heap size is greater than right heap size +1 then move the left top element to right
        if (leftMax.size() > rightMin.size() + 1) {
            rightMin.offer(leftMax.poll());
        } else if (rightMin.size() > leftMax.size()) {
            //If right heap is greater than left heap then move the first right top element to left
            leftMax.offer(rightMin.poll());
        }

    }

    public double findMedian() {

        //If both sizes are equal then avg of both first elements
        if (leftMax.size() == rightMin.size()) {
            return (leftMax.peek() + rightMin.peek()) / 2.0;

        } else {
            //If not median is root of the larger heap
            return leftMax.peek();
        }


    }

    public static void main(String[] args) {
        MedianOfRunningDataStream runningDataStream = new MedianOfRunningDataStream();
        runningDataStream.add(5);
        runningDataStream.add(1);
        System.out.println(runningDataStream.findMedian());

    }


}
