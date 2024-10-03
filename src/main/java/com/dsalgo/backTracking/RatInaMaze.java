package com.dsalgo.backTracking;

public class RatInaMaze {


    public boolean solveMaze(int[][] maze) {

        //This was the solution here which path rat should go to reach the destination
        int[][] sol = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

        //Rat can move to two directions one is down and right,starting from (0,0)
        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.println("Solution Does not exist");
            return false;
        }

        //Print the solution
        printMazeSolution(sol);
        return true;


    }

    private void printMazeSolution(int[][] sol) {

        for (int i = 0; i < sol.length; i++) {

            for (int j = 0; j < sol[0].length; j++) {

                System.out.print(" "+sol[i][j]+" ");
            }
            System.out.println();
        }

    }

    private boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        int n = maze.length;
        //Base Case, this means we reach the destination from (0,0)
        if (x == n - 1 && y == n - 1 && maze[x][y]==1) {
            //then add this to our solution
            sol[x][y] = 1;
            return true;
        }

        //First check the position is safe or not, 0 --> means blocked and 1 -> good to go
        if (isSafe(maze, x, y, n)) {
            //Mark the solution of x and y they are good to go for now
            sol[x][y] = 1;

            //Now check for right and downward direction we can go or not for that again call the same function
            if (solveMazeUtil(maze, x + 1, y, sol)) {
                return true;
            }

            if (solveMazeUtil(maze, x, y + 1, sol)) {
                return true;
            }

            //If any one of the case return false then it is invalid path try another path, so reverting the decision we made earlier
            sol[x][y] = 0;
            return false;

        }

        return false;
    }

    private boolean isSafe(int[][] maze, int x, int y, int n) {

        //Safe condition, x and y should be greater than zero and it should be less than n and the coordinates in maze should be 1
        return x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1;

    }

    public static void main(String[] args) {
        RatInaMaze ratInaMaze=new RatInaMaze();
        int maze[][] = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        ratInaMaze.solveMaze(maze);
    }


}
