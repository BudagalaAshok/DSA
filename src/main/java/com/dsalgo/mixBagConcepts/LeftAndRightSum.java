package com.dsalgo.mixBagConcepts;

import java.util.Scanner;

public class LeftAndRightSum {

    public static void printLeftAndRightSum(int[] arr) {


        int totalLength = arr.length;
        int[] b = new int[totalLength];
        for (int i = 0; i < totalLength; i++) {
            int leftSum = 0;
            int rightSum = 0;
            //left Sum
            if (i != 0) {
                for (int left = i-1; left >= 0; left--) {
                    leftSum += arr[left];
                }
            }
            if (i != totalLength) {
                for (int right = i+1; right <totalLength; right++) {
                    rightSum += arr[right];
                }
            }
            b[i] = Math.abs(leftSum - rightSum);

        }
        for (int eachNum : b) {
            System.out.print(eachNum + " ");
        }


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int range = sc.nextInt();
        int[] arr = new int[range];
        for (int i = 0; i < range; i++) {
            arr[i] = sc.nextInt();
        }
        printLeftAndRightSum(arr);
    }

}
