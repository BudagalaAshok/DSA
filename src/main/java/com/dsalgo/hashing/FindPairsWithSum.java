package com.dsalgo.hashing;

import java.util.HashMap;
import java.util.Map;

public class FindPairsWithSum {


    public static boolean findPairsWithTargetSum(int[] arr,int k){

        Map<Integer,Integer> integerMap=new HashMap<>();
        for(int number:arr){
            if(integerMap.containsKey(number)) {
                integerMap.put(number, integerMap.get(number) + 1);
            }else{
                integerMap.put(number,1);
            }
        }

        for(int eachNumber:arr){

            int difference=k-eachNumber;
            //To handle i not equal to j scenario we need to add below condition

            if(integerMap.containsKey(difference)){
                if(eachNumber!=difference) {
                    return true;
                }
                if(eachNumber==difference && integerMap.get(difference)>=2){
                    return true;
                }
            }

        }

        return  false;

    }

    public static int[] findPairsAndReturn(int[] nums, int target){
        Map<Integer,Integer> numsMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){

            int compliment=target-nums[i];

            if(numsMap.containsKey(compliment)){
                return new int[]{numsMap.get(compliment),i};
            }
            numsMap.put(nums[i],i);

        }
        return null;
    }

    public static void main(String[] args) {
       // System.out.println(findPairsWithTargetSum(new int[]{2,7,8,10},11));
        System.out.println(findPairsAndReturn(new int[]{2,7,11,15},9));
    }

}
