package com.dsalgo.mixBagConcepts;

import java.util.Arrays;


public class SubSetOfArray {

    public static void printSubsetsOfArray(int[] arr) {

        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < (1 << n); i++) {

            for (int j = 0; j < n; j++) {
                if (checkBit(i, j) != 0) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println("\n");
        }
        System.out.println("\n\n");


    }

    private static int checkBit(int i, int j) {
        return (i >> j) & 1;
    }

    public static boolean isSubsetFound(int[] arr, int target, int index) {

        if (index == -1) {
            return target == 0;
        }
        return isSubsetFound(arr, target - arr[index], index - 1) || isSubsetFound(arr, target, index - 1);


    }

    public static void main(String[] args) {
        //printSubsetsOfArray(new int[]{5, 15, 3});
        System.out.println("Subset Found "+isSubsetFound(new int[]{12,5,-3},9,2));
    }

}
