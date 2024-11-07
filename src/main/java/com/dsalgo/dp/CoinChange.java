package com.dsalgo.dp;


//Here we can pick the coin or does not pick the coin
//and also we can pick the coin any no of times

import java.util.Arrays;

public class CoinChange {


    /**
     * In this problem we have to consider below cases one is we are having one coin and the target we have left are we able to form the remaining target with the single left coin or not.
     * If it is formed then return 1 otherwise return 0. Remaining two cases are pick and non_pick let say if we pick then we are subtracting the coin amount from target and moving to the next coin
     * Other wise we don't pick and move to the next coin. While picking the coin the coin value should be less than or equal to the target
     * @param index
     * @param target
     * @param denominations
     * @return
     */


    //Top Down approach using recursion
    public static long findCoinsPickUsingRecursion(int index, int target, int[] denominations) {

        //Base Condition
        if (index == 0) {
            //Let say we have a target and having only single element if we are able
            // to form the target using the element then we can return 1 otherwise 0
            if(target % denominations[0] == 0) {
                return 1;
            }else {
                return 0;
            }
        }

        //Now we have pick and non-pick case
        long non_pick = findCoinsPickUsingRecursion(index - 1, target, denominations);
        //Here we can pick the coin it is less than or equal to target
        long pick = 0;
        if (denominations[index] <= target) {
            //If we pick the element multiple times so if we are at same index and reducing the amount from target
            pick = findCoinsPickUsingRecursion(index, target - denominations[index], denominations);
        }
        return non_pick + pick;
    }

    //Using Memoization, Top Down approach
   public static long findCoinsUsingMemoization(int index, int target, int[] denominations, long[][] dp) {

        //Base Condition , for 0th element in the target
        //Here two values are changing one is index and another one is target so define 2D DP array

        if (index == 0) {
            //Let say we have a target and having only single element if we are able
            // to form the target using the element then we can return 1 otherwise 0
            return target % denominations[index]==0 ? 1 : 0;
        }

        for (int i = 0; i < target; i++) {
            dp[0][i] = (target / denominations[0] % 2 == 0) ? 1 : 0;
        }
        if (dp[index][target] != -1) {
            return dp[index][target];
        }
        long non_pick = findCoinsUsingMemoization(index - 1, target, denominations, dp);
        //Here we can pick the coin it is less than or equal to target
        long pick = 0;
        if (denominations[index] <= target) {
            //If we pick the element multiple times so if we are at same index and reducing the amount from target
            pick = findCoinsUsingMemoization(index, target - denominations[index], denominations, dp);
        }
        return dp[index][target] = non_pick + pick;

    }


    //Bottom Up approach
    public static long findCoinsUsingTabulation(int target, int[] denominations, int n) {

        //Base Condition , for 0th element in the target
        //Here two values are changing one is index and another one is target so define 2D DP array
        long[][] dp=new long[n][target+1];

        for (int i = 0; i <= target; i++) {
            dp[0][i] = (i % denominations[0] == 0) ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {

            for (int j = 0; j <= target; j++) {
                long non_pick = dp[i - 1][target];
                //Here we can pick the coin it is less than or equal to target
                long pick = 0;
                if (denominations[i] <= target) {
                    //If we pick the element multiple times so if we are at same index and reducing the amount from target
                    pick = dp[i][j-denominations[i]];
                }
                dp[i][j] = non_pick + pick;
            }

        }
        return dp[n - 1][target];
    }

    //No of ways we can get the target
    public int coinChange(int[] coins, int amount) {
        int index = coins.length - 1;
        int[][] dp = new int[coins.length][amount + 1];

        // Initialize dp array with -1 to signify that subproblem hasn't been solved yet
        for (int[] eachArray : dp) {
            Arrays.fill(eachArray, -1);
        }

        int result = minCoins(coins, amount, index, dp);

        // If result is still Integer.MAX_VALUE, it means the amount cannot be made with the given coins
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public int minCoins(int[] coins, int amount, int index, int[][] dp) {

        // Base case: If amount is 0, no coins are needed
        if (amount == 0) {
            return 0;
        }

        // Base case: If only one coin type is left
        if (index == 0) {
            // If amount can be made with the only remaining coin, return the number of coins required
            if (amount % coins[index] == 0) {
                return amount / coins[index];
            } else {
                return Integer.MAX_VALUE;  // Invalid: amount cannot be made with this coin
            }
        }

        // If subproblem has already been solved, return its value
        if (dp[index][amount] != -1) {
            return dp[index][amount];
        }

        // Case 1: Do not pick the current coin
        int non_pick = minCoins(coins, amount, index - 1, dp);

        // Case 2: Pick the current coin, if its value is less than or equal to the remaining amount
        int pick = Integer.MAX_VALUE;
        if (coins[index] <= amount) {
            int subResult = minCoins(coins, amount - coins[index], index, dp);
            if (subResult != Integer.MAX_VALUE) {
                pick = subResult + 1;  // Add 1 because we're picking one coin
            }
        }

        // Store the minimum result of both cases
        dp[index][amount] = Math.min(pick, non_pick);

        return dp[index][amount];
    }


    public static void main(String[] args) {
        int[] denominations = { 1, 2, 5 };
        int target = 11;
        int n = denominations.length;

        long[][] dp=new long[n][target+1];
        for(long[] row:dp){
            Arrays.fill(row,-1);
        }

        System.out.println("Using Recursion to find coins :"+findCoinsPickUsingRecursion(n-1,target,denominations));
        System.out.println("Using Memoization to find coins :"+findCoinsUsingMemoization(n-1,target,denominations,dp));
        System.out.println("Using Tabulation to find coins :"+findCoinsUsingTabulation(target,denominations,n));

    }

}
