package com.dsalgo.mixBagConcepts;

import java.util.Arrays;

public class CountTriangles {


    public static int countOfTrianglesFormed(int[] arr) {
        // Sort the array in non-decreasing order
        Arrays.sort(arr);
        int count = 0;
        int n = arr.length;

        // Fix one side of the potential triangle and use two pointers to find the other two sides efficiently
        for (int i = n-1; i >=1; i--) {
            int r = i - 1; // Left pointer
            int l = 0; // Right pointer
            while (l<r) {
                // Check if the sum of arr[r] and arr[l] is greater than arr[i]
                if( arr[r] + arr[l] > arr[i]) {
                    // Increment count by the number of valid triangles formed
                    count += (r - l);
                    // Move l to explore other combinations
                    r--;
                } else {
                    // If the sum is not greater, move r to explore other combinations
                    l++;
                }
            }
        }
        return count;
    }

    public static int countTrianglesFormed(int[] arr) {

        //20,23,59,67,72,83
        Arrays.sort(arr);
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        int n = arr.length;

        for (int i = 0; i < n - 2; i++) {
            int eachSideLength = arr[i];
            p1 = i + 1;
            p2 = n-1;
            while (p1 < p2) {
                if (arr[p1] + arr[p2] > eachSideLength) {
                    count +=  (p2 - p1);
                    p2--;
                }else {
                    p1++;
                }
            }

        }
        return count;

       /* while (p1 <= n) {
            p2 = p1 + 1;
            while (p2 <= n) {
                p3 = p2 + 1;
                while (p3 <= n) {
                    if (arr[p1] + arr[p2] > arr[p3]) {
                        count++;
                    }
                    p3++;
                }
                p2++;
            }
            p1++;
        }*/

    }

    public static void main(String[] args) {
        System.out.println("Count of Triangles formed:" + countOfTrianglesFormed(new int[]{4, 2 ,10, 12, 8, 10}));
    }

}
