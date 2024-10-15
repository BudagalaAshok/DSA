package com.dsalgo.heaps;

import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class KthLargestElementInArray {

  public int findKthLargest(int[] nums,int k){
      PriorityQueue<Integer> queue=new PriorityQueue<>();
      for(int element:nums){
          queue.add(element);

          //if the queue size is greater than k then we need to remove the smallest element from the queue
          if(queue.size()>k){
              queue.poll();
          }
      }
      //Once iteration was done we have kth largest element exists in the queue
      return queue.peek();
  }

    public static void main(String[] args) {
        KthLargestElementInArray largestElement=new KthLargestElementInArray();
        System.out.println(largestElement.findKthLargest(new int[]{3,2,1,5,6,4},3));
    }

}
