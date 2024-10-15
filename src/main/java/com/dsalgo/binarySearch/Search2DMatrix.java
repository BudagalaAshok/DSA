package com.dsalgo.binarySearch;

public class Search2DMatrix {

    /**
     * Convert 2D Matrix in to 1D array and then apply binary search on top of it to find the element
     * Why it works because 2D Matrix all the row elements are sorted
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] result = new int[rows * cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[index++] = matrix[i][j];
            }
        }

        int left = 0;
        int right = result.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (result[mid] == target) {
                return true;
            } else if (target < result[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        return false;
    }

    //Time Complexity was O(log(m*n))

    //using space optimization, instead of creating another extra we can calculate the position of row and col by using mid
    public boolean searchMatrixUsingOptimizedSpace(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Convert 1D index back to 2D coordinates
            int rowIndex = mid / cols;
            int colIndex = mid % cols;
            int midElement = matrix[rowIndex][colIndex];

            if (midElement == target) {
                return true;
            } else if (target < midElement) {
                right = mid - 1; //Search right
            } else {
                left = mid + 1; //Search left
            }

        }

        //Element not found
        return false;
    }


    public static void main(String[] args) {
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println("Target Element exists :" + search2DMatrix.searchMatrix(matrix, 3));
    }
}
