package com.dsalgo.twoPointers;

public class FindSumOfPairsUsingTwoPointers {

    public int[] twoSum(int[] numbers, int target) {

        int[] ans=new int[2];
        int p1=0;
        int p2=numbers.length-1;
        while(p1<p2){
            int calculatedSum=numbers[p1]+numbers[p2];
            if(calculatedSum==target){
                ans[0]=p1+1;
                ans[1]=p2+1;
                break;
            }else if(calculatedSum>target){
                p2--;
            }else if(calculatedSum<target){
                p1++;
            }
        }

        return ans;
    }

}
