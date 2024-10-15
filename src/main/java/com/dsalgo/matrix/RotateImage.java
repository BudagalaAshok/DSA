package com.dsalgo.matrix;

import java.util.Arrays;

public class RotateImage {


    //Bruteforce approach --> O(n to power of 2), space O(n to power of 2)

    public void rotateMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] newRotatedMatrix = new int[n][n];

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                newRotatedMatrix[(n - i) - 1][j] = matrix[i][j];
            }
        }

        for (int[] row : newRotatedMatrix) {
            System.out.println(Arrays.toString(row));
        }

    }

    //Inplace rotation
    //First transpose the matrix i.e convert row in to column and column into row
    //Second step reverse each row and print
    //In this solution we are not using any extra space and tc is same as above solution but space complexity is 1
    public void rotateMatrixWithOutAdditionalSpace(int[][] matrix) {

        //Transpose Matrix
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

        }

        for (int[] row:matrix){
            System.out.println(Arrays.toString(row));
        }

        //Reverse each row under the transpose matrix
        for (int[] row : matrix) {
            reverse(row);
        }


    }

    private void reverse(int[] arr) {

        int p1 = 0;
        int p2 = arr.length - 1;
        while (p1 <= p2) {

            int temp = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = temp;
            p1++;
            p2--;

        }

    }

    public static void main(String[] args) {
        RotateImage rotateImage=new RotateImage();
        int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotateImage.rotateMatrixWithOutAdditionalSpace(matrix);
        for (int[] row:matrix){
            System.out.println(Arrays.toString(row));
        }

    }


}
