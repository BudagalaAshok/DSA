package com.dsalgo.arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateFromSortedArray {

    //TC : O(nlogn)
    public int removeDuplicateFromSortedArray(int[] nums){

        //For insertion it has complexity of O(logn)
        Set<Integer> uniqueElements=new TreeSet<>();
        //Over all n elements so O(nlogn)
        for (int eachNum:nums){
            uniqueElements.add(eachNum);
        }
        int index=0;
        //O(n)
        for (int num:uniqueElements){
            nums[index]=num;
            index++;
        }
        return uniqueElements.size();
    }

    //Optimized solution by comparing previous element with the current element
    //If both are not equal then replace the previous unique element position with the current unique element
    //And increment the uniqueelement pointer
    public int removeDuplicateAndFindUniqueElementCount(int[] nums){

        int j=1;
        for (int i = 1; i <nums.length ; i++) {

            //Because array is sorted already
            if(nums[i]!=nums[i-1]){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;

    }

    //Allow atmost two duplicates
    public int removeDuplicateAndCount(int[] nums){

        int j=1;
        for (int i = 0; i <nums.length ; i++) {

            //Because array is sorted already
            if (i==0 || i==1 || nums[i-2]!=nums[i]){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;

    }


}
