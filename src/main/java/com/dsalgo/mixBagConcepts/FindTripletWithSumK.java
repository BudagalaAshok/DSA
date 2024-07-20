package com.dsalgo.mixBagConcepts;

import java.util.Arrays;

public class FindTripletWithSumK {

    public static boolean findTripletWithSumK(int[] arr, int k) {

        Arrays.sort(arr);
        int n = arr.length - 2;
        for (int i = 0; i < n; i++) {
            int c = k - arr[i];
            int internalP1 = i + 1;
            int internalP2 = arr.length-1;
            while (internalP1 < internalP2) {
                if (arr[internalP1] + arr[internalP2] == c && internalP1 != internalP2) {
                    return true;
                }
                if (arr[internalP1] + arr[internalP2]<c) {
                    internalP1++;
                } else {
                    internalP2--;
                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(findTripletWithSumK(new int[]{5,5,5,10}, 15));
    }
}
