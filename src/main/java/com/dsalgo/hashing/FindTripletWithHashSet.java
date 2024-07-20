package com.dsalgo.hashing;

import java.util.HashSet;
import java.util.Set;

public class FindTripletWithHashSet {

    public static boolean findTripletWithHashSet(int[] arr, int target) {

        Set<Integer> integerSet = new HashSet<>();
        for (int i = 0; i < arr.length - 2; i++) {
            int difference = target - arr[i];
            for (int j = i+1; j < arr.length; j++) {
                int complement =difference-arr[j];
                if(integerSet.contains(complement)){
                    return true;
                }else{
                    integerSet.add(arr[j]);
                }
            }


        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(findTripletWithHashSet(new int[]{1,2,3,4,5,6},15));
    }

}
