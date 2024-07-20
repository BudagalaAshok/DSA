package com.dsalgo.dp;

import java.util.Arrays;

public class LongestCommonSubSequence {


    //Recursive logic to find LCS
    public static int findLCSUsingRecursion(String s1, String s2, int index1, int index2) {

        //Base condition
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        //If both characters are equal at the index we specified
        if (s1.charAt(index1) == s2.charAt(index2)) {
            return 1 + findLCSUsingRecursion(s1, s2, index1 - 1, index2 - 1);
        }

        //if those are not equal then check with one before and one at current position on two strings
        return Math.max(findLCSUsingRecursion(s1, s2, index1 - 1, index2), findLCSUsingRecursion(s1, s2, index1, index2 - 1));

    }

    //Using Memoization Technique(Top Down Approach)
    public static int findLCSUsingMemoization(String s1, String s2, int[][] dp, int idx1, int idx2) {

        //Base condition
        if (idx1 < 0 || idx2 < 0) {
            return 0;
        }
        //Already we calculated
        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        //Otherwise we need to calculate and store
        if (s1.charAt(idx1) == s2.charAt(idx2)) {
            return dp[idx1][idx2] = 1 + findLCSUsingMemoization(s1, s2, dp, idx1 - 1, idx2 - 1);
        } else {
            return dp[idx1][idx2] = Math.max(findLCSUsingMemoization(s1, s2, dp, idx1 - 1, idx2), findLCSUsingMemoization(s1, s2, dp, idx1, idx2 - 1));
        }

    }

    public static int findLCSUsingTabulationApproach(String s1, String s2, int n, int m) {

        //Here consider idx as idx-1
        int[][] dp = new int[n + 1][m + 1];

        //Intialize array with -1
        for (int[] rows : dp) {
            Arrays.fill(rows, -1);
        }
        //Base condition
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int idx1 = 1; idx1 <= n; idx1++) {
            for (int idx2 = 1; idx2 <= m; idx2++) {

                if (s1.charAt(idx1 - 1) == s2.charAt(idx2 - 1)) {
                    dp[idx1][idx2] = 1 + dp[idx1 - 1][idx2 - 1];
                } else {
                    dp[idx1][idx2] = Math.max(dp[idx1 - 1][idx2], dp[idx1][idx2 - 1]);
                }

            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {

        String s1 = "acd";
        String s2 = "ced";
        int n = s1.length();
        int m = s2.length();
        //For memoization
        int[][] dp = new int[n][m];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }

        System.out.println("LCS with length is :"+findLCSUsingMemoization(s1,s2,dp,n-1,m-1));
        System.out.println("LCS with Recursion :"+findLCSUsingRecursion(s1,s2,n-1,m-1));
        System.out.println("LCS using tabulation with length is :"+findLCSUsingTabulationApproach(s1,s2,n,m));

    }

}
