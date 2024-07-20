package com.dsalgo.dp;

public class ZeroByOneKnapsack {

    public static int findMaxWeight(int W, int[] weights, int[] values) {
        int n=weights.length;
        int[] dp=new int[W+1];

        for (int i = 0; i < n; i++) {
            for (int w = W; w >=weights[i] ; w--) {
                //Here we take the item or not taken
                //Let say when we take the item then  the DP Expression was
                //dp[i][w]=Max(dp[i-1,w],dp[i-1][w-w[i]])+p[i]
                dp[w]=Math.max(dp[w],dp[w-weights[i]])+values[i];

            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
         int W=5;
         int[] weights={1,3,4};
         int[] values={15,50,60};
        System.out.println("Maximum value in knapsack ="+ findMaxWeight(W,weights,values));
    }

}
