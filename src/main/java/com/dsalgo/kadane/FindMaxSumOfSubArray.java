package com.dsalgo.kadane;

public class FindMaxSumOfSubArray {


    /**
     * The intuition behind Kadane’s algorithm is to efficiently find the maximum sum of a contiguous sub-array
     * by making a decision at each step: whether to continue adding the current element to the existing sub-array
     * or start a new sub-array.
     */
    public static void findMaxSumOfSubArrayAndPrint(int[] arr) {

        //-2,-5,6,7,-1

        int start = 0;
        int end = 0;
        int maxSum = Integer.MIN_VALUE;
        //Running sum, if running sum becomes negative we start fresh
        int currentSum = 0;
        int tempStart = 0;

        //Kadane's algorithm
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
            if (currentSum < 0) {
                currentSum = 0;
                //If it is negative we start from the next element
                tempStart = i + 1;
            }

        }
        System.out.println("Max sum is :" + maxSum);
        System.out.println("Max Sub Array is :");
        for (int i = start; i <= end; i++) {
            System.out.println(arr[i] + "");
        }


    }


    public static void main(String[] args) {
        findMaxSumOfSubArrayAndPrint(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
    }

}
