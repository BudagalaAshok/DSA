package com.dsalgo.backTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationOfSum {

    //[2,3,6,7], target=7;
    public static void findCombinationSumWithGivenTarget(int index,int[] candidates, int target,List<List<Integer>> ans,List<Integer> numbersAddedList){
        //Base Condition
        //If index is reached to end of array and then check target is equal to zero then it is a valid combination so adding to the final answer
        //For each index we can pick or not and also for each index we can pick multiple times as well
        if(index==candidates.length){
            if(target==0){
                ans.add(new ArrayList(numbersAddedList));
            }
            return;
        }

        if(candidates[index]<=target){
            //Add number to the data-structure
            numbersAddedList.add(candidates[index]);
            findCombinationSumWithGivenTarget(index,candidates,target-candidates[index],ans,numbersAddedList);
            //Once we are done need to remove that value from that data-structure
            numbersAddedList.remove(numbersAddedList.size()-1);

        }
        //Here we are not picking and moving to the next element so target value will not be reduced
        findCombinationSumWithGivenTarget(index+1,candidates,target,ans,numbersAddedList);

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> ans=new ArrayList<>();
        findCombinationSumWithGivenTarget(0,candidates,target,ans,new ArrayList<>());
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Combinations are :"+combinationSum(new int[]{2,3,5,7},7));
    }


}
