package com.dsalgo.binarySearch;

public class MedianOfMatrixUsingBS {


    //Over complexity is (log2 base to to pw of 10 pow 9  * (n * log2 base m))
    public static int findMedianOfSortedMatrix(int[][] matrix, int n, int m) {

        //1 2 3 4 5 6 7 8 9 --> Let say we have n,m is always odd
        int result = (n * m) / 2;
        //Need to find low and high values of an matrix, matrix row wise elements are sorted
        //First row -> First column element was the lowest value
        //Last row  -> Last element was the highest value

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m - 1]);
        }

        while (low <= high) {

            int mid = (low + high) / 2;
            int countOfElementsLTEMid = countNoOfPossibleElements(matrix, mid);
            if (countOfElementsLTEMid <= result) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return low;


    }

    //Time complexity for this method is n*log2 base m
    private static int countNoOfPossibleElements(int[][] matrix, int mid) {

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            count += countLessThanOrEqualTo(row, mid);
        }
        return count;
    }

    public static int countLessThanOrEqualTo(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;

        while (left <= right) {
            //This one is to avoid the over flow of integer value. we can write write directly mid=(low+high)/2 also but this is a good approach
            int mid = left + (right - left) / 2;

            // If target is found, update result and continue search on the left side
            if (arr[mid] == target) {
                result = mid;
                //Here we are updating again right=mid-1 and doing search because in sorted array we have duplicate elements also may be this one is not an
                // first element with the mid value, so proceeding search further on the left side
                right = mid - 1;
            }
            // If target is greater than the current element, search on the right side
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            // If target is smaller than the current element, search on the left side
            else {
                right = mid - 1;
            }
        }

        // If target is not found, the result will be the index of the largest element smaller than the target
        // If target is found, result will be the index of the first occurrence of target
        if (result == -1) {
            result = right;
        }

        // Return the count
        return result + 1;
    }

    public static void main(String[] args) {

        //1,2,3,4,4,5,7,8,9,9,11,11,14,19,20

        int[][] matrix={
                {1,5,7,9,11},
                {2,3,4,8,9},
                {4,11,14,19,20}

        };
        int n=3;
        int m=5;
        System.out.println(findMedianOfSortedMatrix(matrix,n,m));

    }

}
