package com.dsalgo.binarySearch;

public class BinarySearchCount {

    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 2, 2, 3, 4, 5, 6, 7, 8, 8, 9}; // Sorted array
        int target = 6; // Value to search for

        int count = countLessThanOrEqualTo(sortedArray, target);

        System.out.println("Number of elements less than or equal to " + target + ": " + count);
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
}
