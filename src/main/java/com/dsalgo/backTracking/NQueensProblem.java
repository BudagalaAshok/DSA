package com.dsalgo.backTracking;

import org.checkerframework.checker.units.qual.N;

import static jdk.nashorn.internal.objects.Global.print;

/**
 * Time Complexity:
 * O(N!) in the worst case: There are N possible positions in the first row, N-1 in the second row, and so on, leading to N factorial possible configurations to explore.
 **/
public class NQueensProblem {


    public void solveNQueens(int n) {

        int[][] board = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};

        //Here we are iterating each and every column we put the queen first, so passing the first column to start
        solveNQueenUtil(board, 0);


    }

    public void solveNQueensOptimized(int n) {

        int[][] board = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        int[] leftRow = new int[n];
        int[] lowerDiagonal = new int[2 * n - 1];
        int[] upperDiagonal = new int[2 * n - 1];
        //Here we are iterating each and every column we put the queen first, so passing the first column to start
        solveNQueenUtilOptimized(board, 0, leftRow, lowerDiagonal, upperDiagonal);

    }

    private void solveNQueenUtil(int[][] board, int col) {

        //Base condition
        //If col reached end of the board that means we means all queens successfully
        if (col == board.length) {
            //print the board
            System.out.println("*********");
            printBoard(board);
            System.out.println("*********");
            return;
        }

        //Now check to place the queen is it safe or not by iterating all rows
        //Here we are going only via rows because in each row we place only one queen if we place one queen then immediately we can move to the next row
        for (int row = 0; row < board.length; row++) {

            //Here we have options on columns under each row so we have multiple combinations to place. If one combinations does not work then we backtrack and continue
            if (isSafe(board, row, col)) {

                //Mark the row and col in the board and move to the next column
                board[row][col] = 1;
                solveNQueenUtil(board, col + 1);
                //if it is not an successful move then backtrack to the previous state
                board[row][col] = 0;
            }

        }


    }

    private void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {

                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
       To place the queen we need to check left side,left upper diagonal and left below diagonal
       why these three directions because we are placing the queen at the column for the first time as per the
       code no queen placed in right,diagonal,etc in all directions. Here we are traversing row by row so every time we don't check below row because we didn't place the queeen
       Need to check above column level and also from that point to left diagonal and right diagonal
     */

    private boolean isSafe(int[][] board, int row, int col) {

        //First check the left up diagonal part where we place the queen
        int dupRow = row;
        int dupCol = col;
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 1) {
                return false;
            }
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;

        //Now check the left part that means we are in the same row and column got decreasing
        while (col >= 0) {
            if (board[row][col] == 1) {
                return false;
            }
            col--;
        }
        row = dupRow;
        col = dupCol;

        //Now check the left down diagonal part that means row is increasing and col is decreasing
        while (row < board.length && col >= 0) {
            if (board[row][col] == 1) {
                return false;
            }
            row++;
            col--;
        }

        return true;
    }

    //Optimized approach to check the safe position or not instead of using three loops we can use hashing
    //For left row elements we simply mark the row column where it is placed
    //For upper and lower diagonal we can use 2*n-1 array in n*n grid it is 15(2*8-1)
    //For lower diagonal simply mark [row+col] and upper diagonal simply mark [n-1+col-row]
    private void solveNQueenUtilOptimized(int[][] board, int col, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {

        if (col == board.length) {
            printBoard(board);
            System.out.println("********");
            return;
        }

        for (int row = 0; row < board.length; row++) {
            //If it is safe to place the queen or not
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 1;
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solveNQueenUtilOptimized(board, col + 1, leftRow, lowerDiagonal, upperDiagonal);
                //Backtrack
                board[row][col] = 0;
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;

            }
        }


    }


    public static void main(String[] args) {
        NQueensProblem nQueensProblem = new NQueensProblem();
        //nQueensProblem.solveNQueens(4);
        //This is to optimize the isSafe method using hashing
        nQueensProblem.solveNQueens(4);
        //nQueensProblem.solveNQueensOptimized(4);
    }


}
