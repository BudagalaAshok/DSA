package com.dsalgo.backTracking;


/**
 * Time Complexity:
 * <p>
 * •	In the worst case, we might need to explore every cell for each character in the word. The time complexity is O(N * 3^L), where:
 * •	N is the total number of cells in the grid.
 * •	L is the length of the word.
 * •	Each cell has up to 3 adjacent cells (we don’t go back to the visited one), so for each character, we have 3 choices.
 * <p>
 * Space Complexity:
 * <p>
 * •	The space complexity is O(L) due to the recursion depth (since we need space on the stack for each recursive call).
 */
public class WordSearch {

    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[0].length; j++) {
               //If the word is found then return true

                if (dfs(board, word, i, j, 0)) {
                    return true;
                }

            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int index) {

        //Base-case if index is reached the length of the word that means we found the word
        if (index == word.length()) {
            return true;
        }

        //First check for the boundaries
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || board[i][j] != word.charAt(index)) {
            return false;
        }


        char ch = board[i][j];
        //Marking the character as visited
        board[i][j] = '#';

        //search all in four directions and if found return true,up,down,left and right
        boolean found = dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i, j - 1, index + 1) || dfs(board, word, i, j + 1, index + 1);

        //Backtracking and undoing the change exploring the other possibilities
        board[i][j] = ch;
        return found;
    }
}
