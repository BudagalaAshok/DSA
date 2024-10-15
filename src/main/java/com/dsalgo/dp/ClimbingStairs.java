package com.dsalgo.dp;

public class ClimbingStairs {

    //Using Recursion
    public int findWaysUsingRecursion(int n){
        if(n==0 || n==1){
            return 1;
        }

        return findWaysUsingRecursion(n-1)+findWaysUsingRecursion(n-2);
    }

    //using Memoization
    public int climbStairs(int n) {
        // Memoization array to store computed results
        int[] memo = new int[n + 1];
        return climbStairsMemo(n, memo);
    }

    private int climbStairsMemo(int n, int[] memo) {
        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }
        // Check if result is already computed
        if (memo[n] != 0) {
            return memo[n];
        }
        // Recursively calculate and store the result
        memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
        return memo[n];
    }

    //Using TopDown or Tabulation approach
    public int climbStairsUsingTabulation(int n) {
        // Base case for 0 or 1 steps
        if (n == 0 || n == 1) {
            return 1;
        }
        // DP array to store the number of ways to reach each step
        int[] dp = new int[n + 1];
        dp[0] = 1; // 1 way to stay at step 0
        dp[1] = 1; // 1 way to reach step 1

        // Fill the dp array iteratively
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // The answer will be the number of ways to reach step n
        return dp[n];
    }

    //Using Tabulation and space optimization
    public int climbStairsUsingTabAndSpaceOptimization(int n) {
        // Base cases
        if (n == 0 || n == 1) {
            return 1;
        }
        int prev1 = 1; // dp[n-1]
        int prev2 = 1; // dp[n-2]

        // Calculate the number of ways iteratively
        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1; // The final result is stored in prev1
    }


}
