package com.dsalgo.cyclicSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllMissingNumbers {

    //First using cyclic sort place all the elements at the correct position
     //Find missing number we can find like first find the sum of natural number using formulae like n*(n+1)/2
     //Find the total sum of the elements and then calculate the difference of totalSum-ArraySum = gives the missing number
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
            if(nums[j]!=j+1){
                result.add(j+1);
            }
        }

        System.out.println(result.toString());
        return result;

    }

    public static void main(String[] args) {
        FindAllMissingNumbers findAllMissingNumbers=new FindAllMissingNumbers();
        findAllMissingNumbers.findAllMissingNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }
}
