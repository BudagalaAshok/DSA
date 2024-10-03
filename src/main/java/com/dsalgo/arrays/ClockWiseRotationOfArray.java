package com.dsalgo.arrays;

import java.util.Arrays;

public class ClockWiseRotationOfArray {

    public static void clockWiseRotationByDTimes(int[] arr, int d) {

        //We can use two pointers one is start and one is at end by increment start and decrementing end

        //First reverse the array element from 0 to arr.length()-1
        int start = 0;
        int end = arr.length - 1;
        int n = arr.length;
        d = d % n;
        rotateArray(start, end, arr);

        System.out.println(Arrays.toString(arr));


        //After that reverse the array from O to d-1
        start = 0;
        end = d - 1;
        rotateArray(start, end, arr);

        System.out.println(Arrays.toString(arr));

        //After that reverse the array from d to n-1
        start = d;
        end = arr.length - 1;
        rotateArray(start, end, arr);

        System.out.println(Arrays.toString(arr));

    }

    public static void antiClockWiseRotationByDTimes(int[] arr, int d) {
        int n = arr.length - 1;
        d = d % (n + 1);

        //Just reverse the order
        //First reverse start to d-1 elements
        rotateArray(0, d - 1, arr);

        //Second reverse from d to n elements
        rotateArray(d, n, arr);

        //Now reverse the entire array from start to end
        rotateArray(0, n, arr);

        System.out.println(Arrays.toString(arr));

    }

    private static void rotateArray(int startIndex, int endIndex, int[] arr) {
        while (startIndex <= endIndex) {
            int temp = arr[startIndex];
            arr[startIndex] = arr[endIndex];
            arr[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    public static void main(String[] args) {
        clockWiseRotationByDTimes(new int[]{3, 10, 4, 5, 10, 7, 2}, 3);
        antiClockWiseRotationByDTimes(new int[]{3, 10, 4, 5, 10, 7, 2}, 3);
    }
}
