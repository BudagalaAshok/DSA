package com.dsalgo.arrays;

import java.util.Arrays;
import java.util.Stack;

public class FirstSmallerGapOnRightElement {

    // Method to find the first smaller gap on the right for each element
    public static int[] findFirstSmallerOnRight(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];  // To store the difference of index, or 0 if no smaller element
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            // Pop elements from the stack that are greater than or equal to the current element
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            // If stack is empty, no smaller element on the right
            if (stack.isEmpty()) {
                result[i] = 0;
            } else {
                // Calculate the difference in the index
                result[i] = stack.peek() - i;
            }

            // Push the current index onto the stack
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};

        // Find the first smaller element on the right and calculate the index difference
        int[] rightGaps = findFirstSmallerOnRight(arr);
        System.out.println("Index difference to first smaller element on the right: " + Arrays.toString(rightGaps));
    }
}
