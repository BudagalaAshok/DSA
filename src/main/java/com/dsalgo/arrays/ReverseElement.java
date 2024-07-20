package com.dsalgo.arrays;

import java.util.Arrays;

/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
 */

public class ReverseElement {


    //Brute force(O(nlogn)
    public int removeElement(int[] nums, int val) {

        int count = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == val) {
                nums[i] = -1;
            } else {
                count++;
            }

        }

        Arrays.sort(nums);
        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 < p2) {

            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            p1++;
            p2--;

        }
        System.out.println(Arrays.toString(nums));
        return count;

    }


    //O(n)
    public int removeElementOptimized(int[] nums, int val) {
        int index=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]!=val){
                nums[index]=nums[i];
                index++;
            }

        }
        return index;
    }

    public static void main(String[] args) {

        ReverseElement reverseElement = new ReverseElement();
        reverseElement.removeElement(new int[]{3, 2, 2, 3}, 3);
        double length=Math.floorDiv(3,2);
        System.out.println(length);
        int ceilValue= (int) Math.ceil(length);
        System.out.println(ceilValue);

    }

}
