package com.dsalgo.dp;

public class GridUniquePath {


    //Here we can go either right or down one step at a time so possible steps are (i+1,j) || (i,j+1)
    public int findUniquePathUsingRecursion(int[][] grid, int i, int j, int n, int m) {

        //Base case, if we are going out of matrix
        if (i >= n || j >= m) {
            return 0;
        }

        //If it is an obstacle then we need to return 0
        if (grid[i][j] == 1) {
            return 0;
        }

        //If we reaches here that means it is a valid path
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        return findUniquePathUsingRecursion(grid, i + 1, j, n, m) + findUniquePathUsingRecursion(grid, i, j + 1, n, m);

    }

    public int findUniquePathUsingDP(int[][] grid, int i, int j, int n, int m, int[][] dp) {

        //Base case, if we are going out of matrix
        if (i >= n || j >= m) {
            return 0;
        }

        if (grid[i][j] == 1) {
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

        dp[i][j] = findUniquePathUsingDP(grid, i + 1, j, n, m, dp) + findUniquePathUsingDP(grid, i, j + 1, n, m, dp);
        return dp[i][j];

    }

    public int findUniquePathOptimized(int n, int m) {

        //Base case, if we are going out of matrix
        int N = n + m - 2;//Total paths (That means if it is n then we can go up to n-1 and if it is m then we can go up to m-1
        int r = m - 1; //n-1(Here we can take any one either m-1 or n-1

        //By using the equation we find the total paths are ncr so calculating from n & m
        double res = 1;

        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i; //Basically here we are doing ncr
        }
        return (int) res;

    }

    //Tabulation approach
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                //If it is an obstacle then we need to fill it with zero
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                //This is the starting position
                else if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                }
                //Otherwise check for top left and top right
                else {
                    int topLeft = i > 0 ? dp[i - 1][j] : 0;
                    int topRight = j > 0 ? dp[i][j - 1] : 0;
                    dp[i][j] = topLeft + topRight;

                }
            }
        }

        return dp[n - 1][m - 1];

    }

}
