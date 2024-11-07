package com.dsalgo.matrix;


/**
 * Whenever we found a zero in a matrix we need to set that particular row and the column to zero
 */
public class SetZeroMatrix {

    //Brute force approach
    public void setZeroWithBruteForce(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                markRow(matrix, n, m, i);
                markCol(matrix, n, m, j);
            }

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }

            }

        }

    }

    public void markRow(int[][] matrix, int n, int m, int row) {

        for (int i = 0; i < n; i++) {
            if (matrix[row][i] != 0) {
                matrix[row][i] = -1;
            }

        }
    }

    public void markCol(int[][] matrix, int n, int m, int col) {

        for (int i = 0; i < n; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = -1;
            }

        }
    }

    //Time Complexity: O(2*(N*M))
    public void setZeroUsingOptimalApproach(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        //Now if we found any zero in a particular position of row and col we can mark them in specific array related to row and col
        int[] row = new int[n];
        int[] col = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (row[i] == 0 || col[j] == 0) {
                    matrix[i][j] = 0;
                }

            }

        }


    }

    public void setZeroOptimalSpaceApproach(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int col0 = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    //Using the first row
                    matrix[i][0] = 0;
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;

                }
            }
        }
        //Starting from 2nd row and 2nd column, we use first row to store the values as per the previous solution
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != 0) {

                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }

            }

        }
        if (matrix[0][0] == 0) {
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;

            }
        }
        if (col0 == 0) {
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;

            }
        }
    }

    //Optimal approach and easy to understand

    /**
     * First step is to find any zero found in first row or first col if it is found set the respective flags
     * Now iterate from first row and first column if any one of the cell contains zero store the respective information in first row and first column
     * Now iterate again from first and first col using the stored information from first row and first column mark them as zero
     * At last based on the flags we set in first step now set first row or first columns as zero
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int rows=matrix.length;
        int cols=matrix[0].length;
        boolean firstRowToBeZero=false;
        boolean firstColToBeZero=false;

        //Checking first row contains zero
        for(int i=0;i<cols;i++){

            if(matrix[0][i]==0){
                firstRowToBeZero=true;
                break;
            }

        }

        //Checking first col contains zero
        for(int i=0;i<rows;i++){

            if(matrix[i][0]==0){
                firstColToBeZero=true;
                break;
            }

        }

        //Now use the first row and first col to store the information

        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){

                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }

            }
        }

        //Now iterate the matrix and using the first row and col information we can mark the respective matrix as zero

        for(int i=1;i<rows;i++){

            if(matrix[i][0]==0){
                for(int j=1;j<cols;j++){
                    matrix[i][j]=0;
                }
            }
        }

        //check cols
        for(int j=1;j<cols;j++){

            if(matrix[0][j]==0){
                for(int i=1;i<rows;i++){
                    matrix[i][j]=0;
                }
            }
        }

        //Now handle first row and first col
        if(firstRowToBeZero){
            for(int i=0;i<cols;i++){
                matrix[0][i]=0;
            }
        }

        if(firstColToBeZero){
            for(int i=0;i<rows;i++){
                matrix[i][0]=0;
            }
        }

       /* int[] row=new int[m];
        int[] col=new int[n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

              if(matrix[i][j]==0){
                row[i]=1;
                col[j]=1;
              }

            }
        }
         for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

               if(row[i]==1 || col[j]==1){
                matrix[i][j]=0;
               }

              }
            }*/

    }


}
