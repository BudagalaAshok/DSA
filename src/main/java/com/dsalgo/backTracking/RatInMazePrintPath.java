package com.dsalgo.backTracking;

import java.util.ArrayList;
import java.util.List;

public class RatInMazePrintPath {

    public void ratInMaze(int[][] board) {
        List<String> result = new ArrayList<>();
        //Start from first row and first col
        maze(board, 0, 0, "", result);
        if (result.isEmpty()) {
            System.out.println("No Path found");
        } else {
            for (String path : result) {
                System.out.println(path);
            }
        }
    }

    private void maze(int[][] board, int row, int col, String path, List<String> result) {
        int n = board.length;
        //Base case, if the rat reaches the end of the board then that is valid path we can add to the list
        if (row == n - 1 && col == n - 1 && board[row][col] == 1) {
            result.add(path);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = 1;
            //Check for down
            if (row + 1 < n) {
                maze(board, row + 1, col, path + "D", result);
            }

            //Check for up
            if (row - 1 >= 0) {
                maze(board, row - 1, col, path + "U", result);
            }

            //Check for left
            if (col - 1 >= 0) {
                maze(board, row, col - 1, path + "L", result);
            }

            //Check for right
            if (col + 1 < n) {
                maze(board, row, col + 1, path + "R", result);
            }

            board[row][col] = 0;

        }

    }

    private boolean isSafe(int[][] board, int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[0].length && board[row][col] == 1;
    }

}
