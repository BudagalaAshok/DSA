package com.dsalgo.mixBagConcepts;

import java.util.Arrays;

public class SortedSquareArray {

    public int[] sortedSquareArray(int[] nums) {
        //{-10,-5,1,2,4,7}
        int range = nums.length;
        int[] result = new int[range];
        int start = 0;
        int end = nums.length - 1;
        for (int i = range - 1; i > 0; i--) {
            int square;
            if (Math.abs(nums[start]) < Math.abs(nums[end])) {
                square = nums[end];
                end--;
            } else {
                square = nums[start];
                start++;
            }
            result[i] = square * square;
        }
        return result;

    }
    public int[] nonSortedSquareArray(int[] nums) {
        //{-10,-5,1,2,4,7}
        int range = nums.length;
        int[] result = new int[range];
        int start = 0;
        int end = nums.length - 1;
        for (int i = 0; i < range-1; i++) {
            int square;
            if (Math.abs(nums[start]) < Math.abs(nums[end])) {
                square = nums[end];
                end--;
            } else {
                square = nums[start];
                start++;
            }
            result[i] = square * square;
        }
        return result;

    }

    public static void main(String[] args) {
        SortedSquareArray sortedSquareArray = new SortedSquareArray();
        System.out.println(Arrays.toString(sortedSquareArray.sortedSquareArray(new int[]{-10, -5, 1, 2, 4, 7})));
        System.out.println(Arrays.toString(sortedSquareArray.nonSortedSquareArray(new int[]{-10, -5, 1, 2, 4, 7})));
    }

}
