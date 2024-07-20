package com.dsalgo.hashing;

import java.util.HashMap;
import java.util.Map;

public class FindTripletWithTarget {

    //{1,2,3,4,5,6}
    public static boolean findTripletWithTarget(int[] arr, int target) {

        //a+b+c=k ==> c=k-(a+b)
        Map<Integer, Integer> integerCountMap = new HashMap<>();
        for (int eachNumber : arr) {
            integerCountMap.put(eachNumber, integerCountMap.getOrDefault(eachNumber, 0) + 1);
        }

        for (int i=0;i<arr.length-2;i++) {

            int difference=target-arr[i];
            for (int j = i+1; j < arr.length; j++) {
                int complement=difference-arr[j];
                if(integerCountMap.containsKey(complement)){

                    if(complement!=difference){
                        return true;
                    }
                    if(complement==difference && integerCountMap.get(complement)>=2){
                        return true;
                    }
                }

            }



        }
        return false;

    }

}
