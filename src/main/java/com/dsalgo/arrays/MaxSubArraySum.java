package com.dsalgo.arrays;

public class MaxSubArraySum {

    public static long getMaxSubArraySum(int[] arr) {
        long sum = 0;
        long maxSum = Integer.MIN_VALUE;
        int start = 0, ansStart = 0, ansEnd = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum < 0) {
                sum = 0;
                start=i+1;
            }
            if (sum > maxSum) {
                maxSum = sum;
                ansStart = start;
                ansEnd = i;
            }

        }
        System.out.println(maxSum+" "+ansStart+" "+ansEnd);
        return maxSum;

    }

    public static void main(String[] args) {
        getMaxSubArraySum(new int[]{-24, 0, 28, 28, 55, -31, -27, -45, -24});
    }

}
