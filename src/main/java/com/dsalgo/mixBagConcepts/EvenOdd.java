package com.dsalgo.mixBagConcepts;

import java.util.Scanner;

public class EvenOdd {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();
        int[] arr = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            arr[i] = sc.nextInt();
        }
        int even = 0;
        int odd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                even += arr[i];
            } else {
                odd += arr[i];
            }
        }
        System.out.println(even + " " + odd);
    }

}
