package com.dsalgo.tries;

import java.util.ArrayList;
import java.util.List;

/*
  Solving efficiently using Trie and DFS. Instead of trie we need to make multiple dfs calls to do this.
 */
public class WordSearchII {

    TrieNode root;

    public WordSearchII() {
        root = new TrieNode();
    }

    private int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Up, Down, Left, Right
    public List<String> findWords(char[][] board, String[] words) {

        List<String> result = new ArrayList<>();

        //First build a trie with all the words
        TrieNode root = buildTrie(words);
        //Now do the dfs for each word in the board
        //need to check for the word in all 4 directions left,right, up and dow
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);

            }
        }

        return result;

    }

    private void dfs(char[][] board, int i, int j, TrieNode root, List<String> result) {

        //First check for the boundary conditions
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || root.children[board[i][j] - 'a'] == null) {
            return;
        }

        //Check for the base condition
        char ch = board[i][j];
        root = root.children[ch - 'a'];
        if (root.isEndOfWord) {
            result.add(root.word);
            //To avoid duplicate words
            root.isEndOfWord = false;
        }
        //Mark the cell as visited and do the dfs in all 4 directions
        board[i][j] = '#';
        dfs(board, i - 1, j, root, result);//up
        dfs(board, i + 1, j, root, result);//down
        dfs(board, i, j - 1, root, result);//left
        dfs(board, i, j + 1, root, result);//right


        //Now backtrack the mark visited as unvisited for the next iteration -> Restoring
        board[i][j] = ch;

    }

    private TrieNode buildTrie(String[] words) {

        TrieNode current = root;
        for (String eachWord : words) {

            for (char eachChar : eachWord.toCharArray()) {
                if (current.children[eachChar - 'a'] == null) {
                    current.children[eachChar] = new TrieNode();
                }
                current = current.children[eachChar - 'a'];
            }
            current.isEndOfWord = true;
            current.word = eachWord;

        }

        return root;
    }



    //Using only DFS to search
    public List<String> findWordsAnotherApproach(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        for (String word : words) {
            boolean found = false;  // Flag to indicate if the word is found
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // Start DFS if the first character matches
                    if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0)) {
                        result.add(word);
                        found = true;  // Mark word as found
                        break; // No need to search for this word anymore
                    }
                }
                if (found) break; // Exit outer loop if word is found
            }
        }

        return result;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        // Base cases
        if (index == word.length()) return true; // Word is found
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j]=='#' || board[i][j] != word.charAt(index)) {
            return false; // Out of bounds or character mismatch
        }

        // Mark the cell as visited
        char temp = board[i][j];
        board[i][j] = '#'; // Use '#' to mark visited

        // Explore all directions
        boolean found = false;
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (dfs(board, newRow, newCol, word, index + 1)) {
                found = true; // If any direction leads to the word, mark as found
                break;
            }
        }

        // Restore the original character after backtracking
        board[i][j] = temp;
        return found; // Return whether the word was found
    }

}
