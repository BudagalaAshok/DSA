package com.dsalgo.binarySearch;

import java.util.Arrays;

public class FindRepeatedNumberCountUsingBS {


    public static int findStartingIndexUsingBS(int[] arr, int k) {

        int low = 0;
        int n = arr.length - 1;
        int high = n;
        int p1 = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < k) {
                low = mid + 1;
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                p1 = mid;
                high = mid - 1;
            }
        }
        return p1;

    }

    public static int findEndingIndexUsingBS(int[] arr, int k) {

        int low = 0;
        int n = arr.length - 1;
        int high = n;
        int p2 = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] < k) {
                low = mid + 1;
            } else if (arr[mid] > k) {
                high = mid - 1;
            } else {
                p2 = mid;
                low = mid + 1;
            }
        }
        return p2;

    }

    public static void main(String[] args) {

        int[] arr = new int[]{3, 10, 8, 15, 10, 10, -2, 15, 3, -5, 3, 10, 25, 10, 5};
        Arrays.sort(arr);
        int count=findEndingIndexUsingBS(arr,10)-findStartingIndexUsingBS(arr,10)+1;
        System.out.println(count);

    }


}
