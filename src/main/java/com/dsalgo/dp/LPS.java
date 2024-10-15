package com.dsalgo.dp;

import java.util.Arrays;

public class LPS {

    public int findLPS(String s1) {
        //Now find the reverse string of s1
        StringBuilder stringBuilder = new StringBuilder(s1);
        String s2 = stringBuilder.reverse().toString();
        return findLPSHelper(s1, s2, s1.length() - 1, s2.length() - 1);
    }

    private int findLPSHelper(String s1, String s2, int index1, int index2) {

        //Base-case
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (s1.charAt(index1) == s2.charAt(index2)) {
            return 1 + findLPSHelper(s1, s2, index1 - 1, index2 - 1);
        }

        return Math.max(findLPSHelper(s1, s2, index1 - 1, index2), findLPSHelper(s1, s2, index1, index2 - 1));

    }

    public int findLPSUsingMemoization(String s1, String s2, int index1, int index2, int[][] dp) {

        //Base case
        if (index1 < 0 || index2 < 0) {
            return 0;
        }

        if (dp[index1][index2] != -1) {
            return dp[index1][index2];
        }

        if (s1.charAt(index1) == s2.charAt(index2)) {
            return dp[index1][index2] = 1 + findLPSHelper(s1, s2, index1 - 1, index2 - 1);
        }

        return dp[index1][index2] = Math.max(findLPSHelper(s1, s2, index1 - 1, index2), findLPSHelper(s1, s2, index1, index2 - 1));

    }

    public int findLPSUsingTabulation(String s1, String s2) {
        int n = s1.length(), m = s1.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int[] eachArray : dp) {
            Arrays.fill(eachArray, -1);
        }

        //Now initialize the base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < s1.length(); i++) {

            for (int j = 1; j < s2.length(); j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }

        }

        return dp[n][m];

    }

}
