package com.dsalgo.matrix;


import java.util.HashMap;

/**
 * To implement this in-place (without using extra space for the board), we can use a temporary state to indicate the transitions:
 *
 * 0 → 0: Dead to Dead
 * 1 → 1: Live to Live
 * 1 → 0: Live to Dead (use -1 to indicate a live cell that will die)
 * 0 → 1: Dead to Live (use 2 to indicate a dead cell that will become live)
 */
public class GameOfLife {


    public void gameOfLife(int[][] board) {

        if (board == null || board.length == 0) return;

        int rows = board.length;
        int cols = board[0].length;

        // Directions array to traverse the 8 neighbors of a cell
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                { 0, -1},         { 0, 1},
                { 1, -1}, { 1, 0}, { 1, 1}
        };

        // First pass: Mark the board with temporary states
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = 0;

                // Count live neighbors
                for (int[] dir : directions) {
                    int r = i + dir[0];
                    int c = j + dir[1];

                    if (r >= 0 && r < rows && c >= 0 && c < cols && Math.abs(board[r][c]) == 1) {
                        liveNeighbors++;
                    }
                }

                // Apply the Game of Life rules
                if (board[i][j] == 1 && (liveNeighbors < 2 || liveNeighbors > 3)) {
                    board[i][j] = -1; // Live cell dies
                }

                if (board[i][j] == 0 && liveNeighbors == 3) {
                    board[i][j] = 2; // Dead cell becomes live
                }
            }
        }

        // Second pass: Update the board to the final state
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0; // Convert to dead
                } else if (board[i][j] == 2) {
                    board[i][j] = 1; // Convert to live
                }
            }
        }
    }

}
