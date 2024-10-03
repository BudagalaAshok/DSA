package com.dsalgo.slidingWindow;

//This can be solved via sliding technique
/*
  If the current sum is greater than target then we need to shrink the window by moving the start pointer and
  subtracting the value from the currentSum. If the currentSum is less than the target then we need to expand the window
 */
public class MinimizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for (int end = 0; end < n; end++) {
            sum += nums[end];

            while (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= nums[start];
                start++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    /*
    Sliding Window: Use a sliding window to efficiently find the minimal subarray length.
     Dynamic Adjustment: Expand the window by moving end and contract it by moving start whenever the window sum meets or exceeds the target.
     */
    public static void main(String[] args) {
        MinimizeSubArraySum solution = new MinimizeSubArraySum();
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(solution.minSubArrayLen(target, nums)); // Output: 2
    }
}


