package com.dsalgo.dp;


//Here we can pick the coin or does not pick the coin
//and also we can pick the coin any no of times

import java.util.Arrays;

public class CoinChange {


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


    public static void main(String[] args) {
        int[] denominations = { 1, 2, 3 };
        int target = 4;
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
