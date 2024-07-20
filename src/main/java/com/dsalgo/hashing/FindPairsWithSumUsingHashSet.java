package com.dsalgo.hashing;

import java.util.HashSet;
import java.util.Set;

public class FindPairsWithSumUsingHashSet {

    public static boolean findPairsUsingTarget(int[] arr, int target) {

        Set<Integer> integerSet = new HashSet<>();
        int difference=0;
        for (int i = 0; i < arr.length; i++) {
            difference=target-arr[i];
            if(integerSet.contains(difference)){
                return true;
            }else{
                integerSet.add(arr[i]);
            }

        }
      return false;
    }

    public static void main(String[] args) {
        System.out.println(findPairsUsingTarget(new int[]{2,7,8,10},15));
    }

}
