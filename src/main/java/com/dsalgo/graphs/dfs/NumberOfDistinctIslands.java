package com.dsalgo.graphs.dfs;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {

    public static int countNoOfDistinctIslands(int[][] matrix, int n, int m) {

        //Visited array of size n*m
        boolean[][] visited = new boolean[n][m];
        Set<List<Pair<Integer, Integer>>> distinctIslands = new HashSet<>();
        //now for each cell we will traverse and find the connected cells where we have water
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!visited[i][j]) {
                    //Call DFS here
                    List<Pair<Integer, Integer>> pairs = Lists.newArrayList();
                    dfs(i, j, matrix, visited, pairs, i, j);
                    distinctIslands.add(pairs);
                }

            }

        }

        return distinctIslands.size();
    }

    private static void dfs(int row, int col, int[][] matrix, boolean[][] visited,
                            List<Pair<Integer, Integer>> pairs, int baseRow, int baseCol) {

        visited[row][col] = true;
        pairs.add(Pair.of((row - baseRow), (col - baseCol)));

        //We can go to four directions form i,j then deltaRow and deltaCol will be
        int n = matrix.length;
        int m = matrix[0].length;
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, 1};

        //Because we can go up to 4 directions,for each direction make an dfs to visit that node
        for (int i = 0; i < 4; i++) {

            int nRow = deltaRow[i] + i;
            int nCol = deltaCol[i] + i;
            //It is not visited and it has water
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol] && matrix[nRow][col] == 1) {
                dfs(nRow, nCol, matrix, visited, pairs, baseRow, baseCol);
            }

        }

    }

    /*
     * Another way of writing to count the distinct no of islands
     */

    public int numDistinctIslands(int[][] grid) {
        Set<Set<String>> distinctIslands = new HashSet<>();

        int rows = grid.length;
        int cols = grid[0].length;

        // Iterate through the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {  // Found an unvisited land cell
                    Set<String> shape = new HashSet<>();
                    dfs(grid, i, j, i, j, shape);  // Explore the island and collect its shape
                    distinctIslands.add(shape);  // Add the shape to the set
                }
            }
        }

        return distinctIslands.size();  // The number of distinct islands
    }

    // DFS to collect the shape of the island
    //O(n*m) because we are visiting each and every node at-least once
    //O(n*m) to store the relative coordinates of each island.
    private void dfs(int[][] grid, int i, int j, int baseRow, int baseCol, Set<String> shape) {
        // If out of bounds or water, return
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }

        grid[i][j] = 0;  // Mark the cell as visited

        // Record the position relative to the base (starting point)
        // Here we are adding the shape, to find out the shape we are finding the coordinates of by subtracting
        // baseRow and baseCol from current row and col. So that if any two islands have same shape then we will get the same coordinates
        shape.add((i - baseRow) + "," + (j - baseCol));

        // Explore in four directions
        //After that doing the dfs in all directions
        dfs(grid, i - 1, j, baseRow, baseCol, shape);  // up
        dfs(grid, i + 1, j, baseRow, baseCol, shape);  // down
        dfs(grid, i, j - 1, baseRow, baseCol, shape);  // left
        dfs(grid, i, j + 1, baseRow, baseCol, shape);  // right
    }


    //Now count no of islands instead of distinct islands
    //We can use dfs to traverse the entire graph
    public int numberOfIslands(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int countOfIslands = 0;

        //Iterate each and every in the matrix and check if it is land
        //If it is land then call dfs to traverse all the connected nodes
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    countOfIslands++;
                    //call the dfs on the particular row and column
                    dfsOfIslands(matrix, rows, cols);
                }

            }

        }

        return countOfIslands;


    }

    private void dfsOfIslands(int[][] matrix, int rows, int cols) {

        //Check for bounds of rows and cols and the current position is having water then return
        if (rows < 0 || rows >= matrix.length || cols < 0 || cols >= matrix[0].length || matrix[rows][cols] == 0) {
            return;
        }
        //Mark the node as visited by marking them as 0
        matrix[rows][cols]=0;
        //Now call dfs in all 4 directions from left,right,top and bottom
        dfsOfIslands(matrix, rows - 1, cols);
        dfsOfIslands(matrix, rows + 1, cols);
        dfsOfIslands(matrix, rows, cols - 1);
        dfsOfIslands(matrix, rows, cols + 1);
    }


}
