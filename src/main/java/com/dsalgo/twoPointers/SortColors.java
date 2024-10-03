package com.dsalgo.twoPointers;

import java.util.*;

class SortColors {
    public static int[] sortColors(int[] colors) {

        int start = 0;
        int current = 0;
        int end = colors.length - 1;

        while (current <= end) {

            //Red
            if (colors[current] == 0) {
                int temp = colors[start];
                colors[start] = colors[current];
                colors[current] = temp;

                current++;
                start++;
            }

            //White
            else if (colors[current] == 1) {
                current++;
            }

            //Blue
            else {

                int temp = colors[current];
                colors[current] = colors[end];
                colors[end] = temp;

                end--;
            }
        }

        return colors;
    }

    // Driver code
    public static void main(String[] args) {
        int[][] inputs = {
                {0, 1, 0},
                {1, 1, 0, 2},
                {2, 1, 1, 0, 0},
                {2, 2, 2, 0, 1, 0},
                {2, 1, 1, 0, 1, 0, 2}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tcolors: " + inputs[i]);

            int[] sortedColors = sortColors(inputs[i].clone());
            System.out.println("\n\tThe sorted array is: " + Arrays.toString(sortedColors));

            System.out.println("-");
        }
    }
}
