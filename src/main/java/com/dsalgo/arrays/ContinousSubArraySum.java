package com.dsalgo.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ContinousSubArraySum {



    //Brute Force approach




    /*
      optimal solution using hashmap and prefix sum
     */
    public int subarraySum(int[] arr, int n, int s) {

        // code here

        int count=0;
        int prefixSum=0;
        Map<Integer,Integer> prefixSumMap=new HashMap<>();
        //This is base case we are counting the sum and how many times it has in the array so initially we have sum 0 and appears 1
        prefixSumMap.put(0,1);
        int start=0;
        int end=0;

        for (int i = 0; i < n; i++) {
            prefixSum+=arr[i];
            if(prefixSumMap.containsKey(prefixSum-s)){
                count+=prefixSumMap.get(prefixSum-s);
                end=i;
                System.out.println("Indexes are from :"+start+","+end);
                start=i+1;
            }
            prefixSumMap.put(prefixSum,prefixSumMap.getOrDefault(prefixSum,0)+1);

        }
        return count;

    }

    public static void main(String[] args) {
        ContinousSubArraySum continousSubArraySum = new ContinousSubArraySum();
       // System.out.println(continousSubArraySum.subarraySum(new int[]{1,2,3,4,5,6,7,8,9,10}, 10, 15));
        System.out.println(continousSubArraySum.subarraySum(new int[]{1,2,3,7,5}, 5, 12));
        System.out.println(continousSubArraySum.subarraySum(new int[]{1,2,3,4,5,6,7,8,9,10}, 10, 15));
        System.out.println(continousSubArraySum.subarraySum(new int[]{7,2,1}, 3, 2));
        System.out.println(continousSubArraySum.subarraySum(new int[]{5,3,4}, 3, 2));
    }


}
