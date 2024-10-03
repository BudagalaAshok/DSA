package com.dsalgo.cyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDuplicates {

    /**
     The solution is same as cyclic sort once we sort the elements and then iterate the array by comparing the element and the index is same
     if the element and index+1 is not same then current element is the duplicate
     If the element and index+1 is not same if we index+1 then that is missing number
     */
    public List<Integer> findAllMissingNumbers(int[] nums) {
        List<Integer> result=new ArrayList<>();
        int i = 0;
        while (i < nums.length) {

            int currentIndex=nums[i]-1;
            if(nums[i]!=nums[currentIndex]){
                int temp=nums[i];
                nums[i]=nums[currentIndex];
                nums[currentIndex]=temp;
            }else{
                i++;
            }

        }
        System.out.println(Arrays.toString(nums));

        for (int j = 0; j < nums.length; j++) {
            //If the current element and its index does not match then some thing wrong here
            //Either that particular element got missed in the sequence or either the element got duplicated
            //If we want duplicate then we can add the current element or we want missing then we can add the index+1 element
            if(nums[j]!=j+1){
                result.add(nums[j]);
            }
        }

        return result;

    }

    public static void main(String[] args) {
        FindDuplicates findDuplicates=new FindDuplicates();
        findDuplicates.findAllMissingNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }

}
