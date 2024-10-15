package com.dsalgo.arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateFromSortedArray {

    //TC : O(nlogn)
    public int removeDuplicateFromSortedArray(int[] nums) {

        //For insertion it has complexity of O(logn)
        Set<Integer> uniqueElements = new TreeSet<>();
        //Over all n elements so O(nlogn)
        for (int eachNum : nums) {
            uniqueElements.add(eachNum);
        }
        int index = 0;
        //O(n)
        for (int num : uniqueElements) {
            nums[index] = num;
            index++;
        }
        return uniqueElements.size();
    }

    //Optimized solution by comparing previous element with the current element
    //If both are not equal then replace the previous unique element position with the current unique element
    //And increment the uniqueelement pointer
    public int removeDuplicateAndFindUniqueElementCount(int[] nums) {

        int j = 1;
        for (int i = 1; i < nums.length; i++) {

            //Because array is sorted already
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;

    }

    //Allow atmost two duplicates
    public int removeDuplicateAndCount(int[] nums) {

        // Base case: if the length is less than 3, return the original length
        if (nums.length <= 2) return nums.length;

        // `i` is the position where we place the next valid element
        int i = 2;

        // Start iterating from the third element (index 2) in `nums`
        for (int j = 2; j < nums.length; j++) {
            // If current element `nums[j]` is not the same as `nums[i-2]`
            // This ensures we allow up to 2 occurrences of each element
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j]; // Place the valid element
                i++; // Move the valid placement index forward
            }
        }

        // The new length of the array with at most 2 occurrences of each element
        return i;
    }

    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray duplicateFromSortedArray = new RemoveDuplicateFromSortedArray();
        System.out.println(duplicateFromSortedArray.removeDuplicateAndCount(new int[]{1, 1, 1, 2, 2, 3}));
    }


}
