package com.dsalgo.arrays;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static int[] productExpectSelf(int[] nums) {

        if (nums == null || nums.length == 1) {
            return null;
        }

        //First find the left product by taking an additional array
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        //Put first element as 1 for both left and right
        left[0] = 1;
        right[nums.length - 1] = 1;

        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];

        }

        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        //Now take the results and put the product of left and right
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }

    public static int[] productExpectSelfWithOutExtraSpace(int[] nums) {

        if (nums == null || nums.length == 1) {
            return null;
        }

        //First find the left product by taking an additional array
        int[] output = new int[nums.length];

        //Put first element as 1 for both left and right
        output[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i - 1];

        }

        //Now take an seperate variable to keep the running sum
        // r contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the r would be 1
        int r=1;
        // For the index 'i', R would contain the
        // product of all elements to the right. We update R accordingly
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] = output[i] * r;
            r*=nums[i];
        }

        return output;
    }

    //Now we can solve with out using extra space with O(1) complexity


    public static void main(String[] args) {
        System.out.println("Product of array expect itself :"+Arrays.toString(productExpectSelf(new int[]{1,2,3,4})));
        System.out.println("Product of array expect itself with out extra space :"+Arrays.toString(productExpectSelfWithOutExtraSpace(new int[]{1,2,3,4})));
    }

}
