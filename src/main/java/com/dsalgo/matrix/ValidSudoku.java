package com.dsalgo.matrix;

import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                int num = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + (j / 3);


                if (board[i][j] == '.') {
                    continue;
                }

                if (row[i][num] || col[j][num] || boxes[boxIndex][num]) {
                    return false;
                }

                row[i][num] = true;
                col[j][num] = true;
                boxes[boxIndex][num] = true;

            }

        }

        return true;

    }

    /**
     * How the Solution Works:
     *
     * 	•	Row check: For every number num at position (i, j), we check if it already exists in the i-th row (rows[i]). If it does, the Sudoku is invalid for that row. Otherwise, we add num to rows[i].
     * 	•	Column check: We check if num is already in the j-th column (cols[j]). If it does, the Sudoku is invalid for that column. Otherwise, we add num to cols[j].
     * 	•	Box check: We calculate the box index for the cell (i, j) and check if num already exists in the corresponding 3x3 box (boxes[boxIndex]). If it does, the Sudoku is invalid for that box. Otherwise, we add num to boxes[boxIndex].
     *
     * Efficiency:
     *
     * 	•	Time complexity: The solution checks each number in the board exactly once and does constant-time lookups and insertions into sets. Therefore, the time complexity is O(9 \times 9) = O(81), which is effectively O(1) given the fixed size of the board.
     * 	•	Space complexity: We use three arrays of sets, each of size 9, to track numbers for rows, columns, and boxes. This gives a space complexity of O(9 \times 3) = O(27), which is constant space.
     * @param nums
     * @return
     */
    public boolean isValidSudukoAnotherApproach(char[][] nums) {

        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = nums[i][j];
                if (num != '.') {
                    if (rows[i].contains(num)){
                        return false;
                    }
                    rows[i].add(num);

                    if(cols[j].contains(num)){
                        return false;
                    }

                    cols[j].add(num);

                    int boxIndex=(i/3) *3 + (j/3);
                    if(boxes[boxIndex].contains(num)){
                        return false;
                    }
                    boxes[boxIndex].add(num);

                }

            }


        }
      return true;
    }

}
