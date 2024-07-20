package com.dsalgo.dp;

public class GridUniquePath {


    //Here we can go either right or down one step at a time so possible steps are (i+1,j) || (i,j+1)
    public int findUniquePathUsingRecursion(int i, int j, int n, int m) {

        //Base case, if we are going out of matrix
        if (i >= n || j >= m) {
            return 0;
        }

        //If we reaches here that means it is a valid path
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        return findUniquePathUsingRecursion(i + 1, j, n, m) + findUniquePathUsingRecursion(i, j + 1, n, m);

    }

    public int findUniquePathUsingDP(int i, int j, int n, int m, int[][] dp) {

        //Base case, if we are going out of matrix
        if (i >= n || j >= m) {
            return 0;
        }

        //If we reaches here that means it is a valid path
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        //If already find the solution then return
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = findUniquePathUsingDP(i + 1, j, n, m, dp) + findUniquePathUsingDP(i, j + 1, n, m, dp);
        return dp[i][i];

    }

    public int findUniquePathOptimized(int n, int m) {

        //Base case, if we are going out of matrix
        int N = n + m - 2;//Total paths (That means if it is n then we can go up to n-1 and if it is m then we can go up to m-1
        int r = m - 1; //n-1(Here we can take any one either m-1 or n-1

        //By using the equation we find the total paths are ncr so calculating from n & m
        double res = 1;

        for (int i = 1; i <= r; i++) {
            res=res*(N-r+i)/i; //Basically here we are doing ncr
        }
        return (int)res;

    }

}
