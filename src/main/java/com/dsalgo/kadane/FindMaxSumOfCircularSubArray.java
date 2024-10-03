package com.dsalgo.kadane;

/**
 * Here this circular array means the last element points to the first position of the array
 * Solved using three steps, first is to find the Sum of the array --> Sum
 * Second step is to find the Max Sum using Kadane algorithm  -> MaxSum
 * Third step is to find the max sum by flipping the sign of elements in the array -> MinSum (Once find the minSum we flip the sign)
 * At last we sum all these three and return Sum+MaxSum+MinSum -> return the answer
 */

/**
 * Why Does This Intuition Work?
 *
 * 	•	Normal subarray: Simply pick the best segment of the array (Kadane’s algorithm).
 * 	•	Circular subarray: The key insight is that a circular subarray wraps around the start and end, and we can identify it by removing the minimum subarray from the total sum.
 * 	This is because removing the worst segment leaves us with the best possible wraparound segment.
 *
 * In practical terms, this technique works for finding the most profitable route in a circular scenario where both start and end points
 * matter—like the delivery driver example.
 *
 */
public class FindMaxSumOfCircularSubArray {

    public int findMaxCircularSubArraySum(int[] arr) {

        //First find the max Sum
        int totalSum = 0;
        for (int eachNum : arr) {
            totalSum += eachNum;
        }

        //Next find the maxSum using kadane algorithm this is called the non-wrapping sub array
        int maxSum = findMaxSumUsingKadane(arr);

        //Next find the minSum using modified kadane algorithm this is called the wrapping sub array. Starts from the in the middle of the array
        // and then pointing to the starting position of array
        int minSum = findMinSumUsingModifiedKadane(arr);

        //Now let say minSum contains all the negative elements and the sum is equal to the total sum then return the maxSum
        if(minSum==totalSum){
            return maxSum;
        }

        //Otherwise find max of maxSubArraySum and totalSum-minSubArraySum
        return Math.max(maxSum,totalSum-minSum);

    }

    private int findMinSumUsingModifiedKadane(int[] arr) {

        int minSum = Integer.MAX_VALUE;
        int currentMinSum = 0;
        for (int element : arr) {
            //Find minimum between currentMinSum and current element
            currentMinSum = Math.min(currentMinSum + element, element);
            minSum=Math.min(currentMinSum,minSum);
        }
        return minSum;
    }

    public int findMaxSumUsingKadane(int[] nums) {

        int start = 0;
        int end = 0;
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int currentStart = 0;
        for (int i = 0; i < nums.length; i++) {

            currentSum += nums[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = currentStart;
                end = i;
            }
            if (currentSum < 0) {
                currentSum = 0;
                currentStart = i + 1;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        FindMaxSumOfCircularSubArray sumOfCircularSubArray=new FindMaxSumOfCircularSubArray();
        sumOfCircularSubArray.findMaxCircularSubArraySum(new int[]{7, 8, -1, 3, -4, 5});
    }

}
