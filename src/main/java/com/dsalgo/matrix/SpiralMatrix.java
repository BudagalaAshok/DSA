package com.dsalgo.matrix;

import com.google.common.collect.Lists;

import java.util.List;


//O(nxm) --> Time complexity because we are iterating each and every row as well as column
public class SpiralMatrix {

    /**
     * 1  2  3  4  5
     * 6  7  8  9 10
     * 11 12 13 14 15
     * 16 17 18 19 20
     * 21 22 23 24 25
     */


    public static List<Integer> printSpiralMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        List<Integer> spiralList = Lists.newLinkedList();
        int top = 0, bottom = n - 1, left = 0, right = m - 1;

        //Need to print the left in this direction first right -> bottom -> left -> top (THis one we will put in our for conditions)
        while (top <= bottom && left <= right) {


            //Print first row from left to right
            for (int i = left; i <= right; i++) {
                spiralList.add(matrix[top][i]);
            }
            //once down increment the top that means to the next row
            top++;

            //NOw print the right column
            for (int i = top; i <= bottom; i++) {
                spiralList.add(matrix[i][right]);
            }

            //Once done adding the right most column then move to before next column
            right--;

            //Now print the last row from left
            if (top <= bottom) {
                for (int i = right; i >= left; i++) {
                    spiralList.add(matrix[bottom][i]);
                }

                //Once done we need to print the top row so we are moving to top so
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    spiralList.add(matrix[i][top]);
                }
                //Then move the left pointer to second column because we need to print from second row same approach as above
                left++;
            }

        }

        return spiralList;

    }


    public static void main(String[] args) {
        System.out.println(printSpiralMatrix(new int[][]{{5},{4},{3},{2},{1}}));
    }

}
