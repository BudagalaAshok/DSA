package com.dsalgo.mixBagConcepts;

import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {

        int swapCount = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - i - 1; j++) {

                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapCount++;
                }

            }
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(swapCount);

    }

    public static void main(String[] args) {
        bubbleSort(new int[]{274, 204, -161, 481, -606, -767, -351});
    }

}
