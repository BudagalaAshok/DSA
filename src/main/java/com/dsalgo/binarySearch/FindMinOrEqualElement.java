package com.dsalgo.binarySearch;


import java.util.Arrays;

//Find a Q element in an array where arr[i]<=Q using binary search
public class FindMinOrEqualElement {

    public static int findMinOrEqualElementUsingBS(int[] arr, int k) {

        Arrays.sort(arr);
        int minElement = Integer.MIN_VALUE;
        int n = arr.length - 1;
        int low = 0;
        int high = n ;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < k) {
                minElement = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return minElement;


    }

    public static void main(String[] args) {
        System.out.println(findMinOrEqualElementUsingBS(new int[]{12, 21, 15, -3, 10, -8, 5, 29, 18}, 0));
    }
}
