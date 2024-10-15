package com.dsalgo.graphs.dfs;

public class SurrondedRegionsDFS {

    public void markSurrondedRegions(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        //Start with the boundaries having zero and do dfs in all four directions until and unless we can't do further
        //If it is visited then mark that position as already visited with 1
        //Next try to find another boundary with zero having left,right,top and bottom
        //Once it is done we need to mark the unvisited places with X

        // Step 1: Mark all boundary-connected 'O's and their connected components
        //First do the boundary rows i.e first and last
        for (int i = 0; i < cols; i++) {

            //First row
            if (!visited[0][i] && matrix[0][i] == 'O') {
                dfs(matrix, visited, 0, i);
            }

            //Last row
            if (!visited[rows - 1][i] && matrix[rows - 1][i] == 'O') {
                dfs(matrix, visited, rows - 1, i);
            }

        }

        //First do the boundary columns i.e left and right
        for (int i = 0; i < rows; i++) {

            //First col
            if (!visited[i][0] && matrix[i][0] == 'O') {
                dfs(matrix, visited, i, 0);
            }

            //Last col
            if (!visited[i][cols - 1] && matrix[i][cols - 1] == 'O') {
                dfs(matrix, visited, i, cols - 1);
            }

        }

        //Flip the O with X if it is not visited
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if(matrix[i][j]=='O' && !visited[i][j]){
                    matrix[i][j]='X';
                }

            }

        }

    }

    public void dfs(char[][] matrix, boolean[][] visited, int row, int col) {

        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || visited[row][col] || matrix[row][col] != 'O') {
            return;
        }

        //mark the visited node as true
        visited[row][col]=true;

        dfs(matrix, visited, row - 1, col); //up
        dfs(matrix, visited, row + 1, col); //down
        dfs(matrix, visited, row, col - 1); //right
        dfs(matrix, visited, row, col + 1); //left

    }

}
