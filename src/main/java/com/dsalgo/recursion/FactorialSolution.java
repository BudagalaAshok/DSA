package com.dsalgo.recursion;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class FactorialSolution {


    public int fact(int num, int[] dp) {
        if (num <= 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (dp[num] != -1) {
            return dp[num];
        }
        dp[num] = num * fact(num - 1, dp);
        return dp[num];
    }

    public int factUsingTabulation(int num) {
        int[] dp = new int[num + 1];
        if (num <= 0) {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i <= num; i++) {
            dp[i] =i * dp[i - 1];
        }

        return dp[num];

    }

    //Convert this in to DP


    public static void main(String[] args) {
        FactorialSolution factorialSolution = new FactorialSolution();
        int n = 5;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        //System.out.println("Factorial was :" + factorialSolution.fact(n, dp));
        System.out.println("Factorial using Tabulation :"+factorialSolution.factUsingTabulation(n));
    }

}
