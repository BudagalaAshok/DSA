package com.dsalgo.mixBagConcepts;

import java.util.ArrayList;
import java.util.List;

public class EvenOddLongestSubArrayLength {

    public static int countLongestEvenOddArray(int[] arr){

        //Brute Force approach gives 0(n to power of 2), O(1)
        int maxCount=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int count=1;
            for(int j=i+1;j<arr.length;j++){

                 if((arr[j]%2==0 && arr[j-1]%2!=0) ||(arr[j]%2!=0 && arr[j-1]%2==0)){
                     count++;
                 }else{
                     break;
                 }
            }

            maxCount=Integer.max(maxCount,count);

        }
        return maxCount;

    }

    public static int countLongestEvenOddSecondApproach(int[] arr){
        int count=1;
        int maxCount=Integer.MIN_VALUE;
        for(int i=1;i<arr.length;i++){

            boolean previousElement=arr[i-1] % 2 == 0;
            boolean isEvenOrOdd= arr[i] % 2 == 0;
            if((isEvenOrOdd && !previousElement) || (!isEvenOrOdd && previousElement)){
                count++;
                maxCount=Math.max(maxCount,count);
            }else{
              count=1;
            }
        }
        return maxCount;

    }

    public static void main(String[] args) {
        //System.out.println("Longest Even Odd Count :"+countLongestEvenOddArray(new int[]{8,10,13,14,15,18,19,20}));
        System.out.println("Longest Even Odd Count :"+countLongestEvenOddSecondApproach(new int[]{8,10,13,14,15,18,19,20}));
    }

}
