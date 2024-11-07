package com.dsalgo.dp;

import java.util.Arrays;

/**
 * Given an integer array nums, return the length of the longest strictly increasing
 * subsequence
 * Example 1:
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 */

public class LongestIncreasingSequence {

    //Find the length of longest increasing sequence

    /**
     * Express everything in terms of index
     * now explore the combinations in terms of index
     * Now take the maximum of take/not_take
     */

    //First one is using recursion and time complexity was O(2^n) and space complexity was O(n)
    public int findLIS(int[] nums) {

        return findLISUsingRecursion(nums, 0, -1);
    }

    //For Memoization
    public int findLIS(int[] nums, int n) {
        int[][] dp = new int[n][n + 1];
        for (int[] each : dp) {
            Arrays.fill(each, -1);
        }
        return findLISUsingMemoization(nums, 0, -1, dp);
    }

    private int findLISUsingRecursion(int[] nums, int index, int prevIndex) {

        //basecase, If it reaches the end of the array then we don't have any elements to take so it is retuning zero
        if (index == nums.length) {
            return 0;
        }

        //Now we have two cases one is take and another one is not take
        //If we don't take that element then we move to next index and previous index remain same, we are not picking that element our length remains same
        int not_take = findLISUsingRecursion(nums, index + 1, prevIndex);

        //Now we have another case called take, whenever we are picking if the prevIndex is -1 that means we didn't take any element up to now
        //or if the currentindex value is greater than previous index value then we need to take that means we are increasing sequence length by 1
        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + findLISUsingRecursion(nums, index + 1, index);
        }

        //at last we take the max of take and not_Take
        return Math.max(take, not_take);
    }

    //Using Memoization, to solve this using 2D array and with size of n*n+1
    //First one is to store the index and the previous index, for previous index we initially start with -1 so not possible to store -1 here
    //So for -1 we start with 0 and then for 0 ->1,1->2...so on
    //TC:O(n*n), sc:0(n*n)
    private int findLISUsingMemoization(int[] nums, int index, int prevIndex, int[][] dp) {

        //Base case
        if (index == nums.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }
        int not_take = findLISUsingRecursion(nums, index + 1, prevIndex);
        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = 1 + findLISUsingRecursion(nums, index + 1, index);
        }

        dp[index][prevIndex + 1] = Math.max(take, not_take);
        return dp[index][prevIndex + 1];
    }

    //Using Tabulation and optimized approach

    /**
     * 1.	Define DP array: Let dp[i] represent the length of the longest increasing subsequence ending at index i.
     * 2.	Initialize: Initialize dp[i] = 1 for all i, because every element can form a subsequence of length 1 by itself.
     * 3.	Recurrence: For each element i, check all previous elements j (where j < i). If arr[i] > arr[j], then we update dp[i] as:
     * dp[i] = max(dp[i], dp[j] + 1)
     * 4.	Result: The length of the longest increasing subsequence is the maximum value in the dp array.
     * @param nums
     * @param n
     * @return
     */
    private int findLISUsingTabulation(int[] nums, int n) {
        int maxLength = 1;
        int[] dp = new int[n];
        //Because by default all the numbers at index i forms 1 sequence length, each number is of unique length 1
        Arrays.fill(dp, 1);

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {
                //Checking all previous elements with the current element if any element is less than the current element
                //Then update the current element by taking the value
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);// update the dp value if the value is already greater than the updated value don't change
                }

            }
            maxLength = Math.max(maxLength, dp[i]);

        }

        return maxLength;

    }




}
