package com.dsalgo.arrays;

import java.util.Arrays;

public class ClockWiseRotationOfArray {

    public static void clockWiseRotationByDTimes(int[] arr, int d){

        //We can use two pointers one is start and one is at end by increment start and decrementing end

        //First reverse the array element from 0 to arr.length()-1
        int start=0;
        int end=arr.length-1;
        int n=arr.length;
        d=d%n;
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

        System.out.println(Arrays.toString(arr));


        //After that reverse the array from O to d-1
        start=0;
        end=d-1;
        while(start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

        System.out.println(Arrays.toString(arr));

        //After that reverse the array from d to n-1
        start=d;
        end=arr.length-1;
        while (start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }

        System.out.println(Arrays.toString(arr));

    }

    public static void main(String[] args) {
        clockWiseRotationByDTimes(new int[]{3, 10, 4 ,5, 10, 7, 2},3);
    }
}
