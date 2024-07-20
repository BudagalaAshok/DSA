package com.dsalgo.dp;

import java.util.Arrays;

public class HouseRobber {

    public static int findSumWithOutAdjacentElements(int[] arr, int index) {

        //Base Condition. This condition will arise if we don't pick the index=1 element
        if (index == 0) {
            return arr[index];
        }
        //This case will arise when we pick the (index=1)first element
        if (index < 0) {
            return 0;
        }

        int pick = arr[index] + findSumWithOutAdjacentElements(arr, index - 2);
        int not_pick = findSumWithOutAdjacentElements(arr, index - 1);
        return Math.max(pick, not_pick);

    }

    public static int findSumWithOutAdjacentElementsUsingMemoization(int[] arr, int index, int[] dp) {

        //Base Condition. This condition will arise if we don't pick the index=1 element
        if (index == 0) {
            return arr[index];
        }
        //This case will arise when we pick the (index=1)first element
        if (index < 0) {
            return 0;
        }
        //Already computed
        if (dp[index] != 1) {
            return dp[index];
        }

        int pick = arr[index] + findSumWithOutAdjacentElementsUsingMemoization(arr, index - 2, dp);
        int not_pick = findSumWithOutAdjacentElementsUsingMemoization(arr, index - 1, dp);
        dp[index] = Math.max(pick, not_pick);
        return dp[index];
    }

    //Tabulation Bottom-up Approach
    public static int findAdjacentSumWithTabulation(int[] arr) {

        int[] dp = new int[arr.length];
        //Base Condition. This condition will arise if we don't pick the index=1 element
        dp[0] = arr[0];
        //Now start from index=1 to n
        for (int i = 1; i < arr.length; i++) {

            int pick = arr[i];
            if (i > 1) {
                pick += dp[i - 2];
            }
            int not_pick = dp[i - 1];
            dp[i] = Math.max(pick, not_pick);

        }

       return dp[arr.length-1];
    }

    //Space optimization
    public static int findAdjacentSumWithTabulationAndSpace(int[] arr) {

        //Base Condition. This condition will arise if we don't pick the index=1 element
        int prev = arr[0];
        int prev2=0;
        //Now start from index=1 to n
        for (int i = 1; i < arr.length; i++) {

            int pick = arr[i];
            if (i > 1) {
                pick += prev2;
            }
            int not_pick = prev;
            int curr = Math.max(pick, not_pick);
            prev2=prev;
            prev=curr;

        }

        return prev;
    }

    public static void main(String[] args) {

        int arr[]={2,1,4,9};
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.println("Adjacent sum using Memoization :"+findSumWithOutAdjacentElementsUsingMemoization(arr,n-1,dp));
        System.out.println("Adjacent sum using Tabulation " +findAdjacentSumWithTabulation(arr));
        System.out.println("Adjacent sum using Tabulation and space: "+findAdjacentSumWithTabulationAndSpace(arr));
        System.out.println("Adjacent sum using Tabulation and space: "+findSumWithOutAdjacentElements(arr,n-1));

    }

}
