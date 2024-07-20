package com.dsalgo.hashing;

import java.util.HashSet;
import java.util.Set;

public class FindPairsWithDifferenceHashSet {

    public static boolean findPairsWithDifference(int[] arr, int target){

        Set<Integer> integerSet=new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int difference=target+arr[i];
            if(integerSet.contains(difference)){
                return true;
            }else{
                integerSet.add(arr[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
