package com.dsalgo.dp;

import java.util.Arrays;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */
public class MinPathSum {

    //Recursive Solution
    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        return findPath(n, m, grid);

    }

    /**
     * Here we are going from bottom to top so if we reach the first row and first col then we are done
     *
     * @param row
     * @param col
     * @param grid
     * @return
     */
    public int findPath(int row, int col, int[][] grid) {

        //Base case
        if (row == 0 && col == 0) {
            return grid[row][col];
        }

        //Check for exceeding boundaries
        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }

        //Find the up and left path sum and take the minimum and return
        int up = grid[row][col] + findPath(row - 1, col, grid);
        int left = grid[row][col] + findPath(row, col - 1, grid);
        return Math.min(up, left);
    }

    //Using Memoization
    public int minPathSumUsingMemoization(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return findMinPathSum(grid, n, m, dp);

    }

    /**
     * Using Memoization
     *
     * @param grid
     * @param row
     * @param col
     * @param dp
     * @return
     */

    private int findMinPathSum(int[][] grid, int row, int col, int[][] dp) {

        //Base case
        if (row == 0 && col == 0) {
            return grid[row][col];
        }

        if (row < 0 || col < 0) {
            return Integer.MAX_VALUE;
        }


        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        //Find the up and left path sum and take the minimum and return we are moving from the current cell
        int up = grid[row][col] + findMinPathSum(grid, row + 1, col, dp);
        int left = grid[row][col] + findMinPathSum(grid, row, col - 1, dp);
        return dp[row][col] = Math.min(up, left);
    }

    public int minPathSumUsingTabulation(int[][] grid) {

        int rows=grid.length;
        int cols=grid[0].length;

        int[][] dp=new int[rows][cols];
        dp[0][0]=grid[0][0];

        //Fill the first column
        for(int i=1;i<rows;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        //Fill the first row
        for(int j=1;j<cols;j++){
            dp[0][j]=dp[0][j-1]+grid[0][j];
        }

        for(int i=1;i<rows;i++){

            for(int j=1;j<cols;j++){

                dp[i][j]=grid[i][j]+Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }


        return dp[rows-1][cols-1];

    }


    public static void main(String[] args) {
        MinPathSum minPathSum=new MinPathSum();
        // Define the matrix
        int matrix[][] = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        int n = matrix.length;
        int m = matrix[0].length;

        // Calculate and print the minimum sum path in the matrix
        System.out.println(minPathSum.minPathSumUsingTabulation(matrix));
    }

}
