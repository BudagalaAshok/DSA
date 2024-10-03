package com.dsalgo.twoPointers;


import java.util.*;

/**
 * This problem can be solved using three for loops and find the sum of three values is equal to k, if it is equal then add
 * the elements to an collection and then sort -> It gives the time complexity of O(n^3) and sorting only three elements i.e log
 */
public class ThreeSumTargetEqualToZero {

    //Better approach using two for loops and an hashset to store the elements and finding the difference in the set.
    // If found then add the three elements to an list and then sort and then add the result to the answer list
    public List<List<Integer>> findUniqueTripletWithTargetAsZero(int[] arr, int k) {

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {

            //Now initialize the HashSet for each and every i we need to clear the set
            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < arr.length; j++) {
                int third = -(arr[i] + arr[j]);
                if (set.contains(third)) {
                    List<Integer> elements = Arrays.asList(arr[i], arr[j], third);
                    elements.sort(null);
                    result.add(elements);
                }
                //Now insert the jth element to the hashset
                set.add(arr[j]);
            }

        }
        return result;
    }

    //Optimal approach using two pointer, First step is to sort the given array
    //Next start two pointers and then move the pointers to find the triplet
    //Time complexity is O(nlogn * n^2)
    public List<List<Integer>> findUniqueTripletUsingTwoPointer(int[] arr) {

        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(arr);
        //Now we have fixed the first pointer position, and then we have two pointers moving forward and backward.
        // Next pointer starts from first pointer and second pointer points last position of the array
        for (int i = 0; i < arr.length; i++) {

            //If the current element is same as previous one then we need to move forward until and unless it is different
            //For the first element we don't have the previous one so checking the below condition
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            //Now start two pointers
            int j = i + 1;
            int k = arr.length - 1;

            //Now iterate until j<k
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                //There are three cases here one is sum is less than zero and another condition is greater than zero and third case was sum is equal to zero

                if (sum < 0) {
                    j++;
                }else if(sum >0){
                    k--;
                }else{
                    //Now we found the triplet add to the result
                   List<Integer> ans= Arrays.asList(arr[i],arr[j],arr[k]);
                   result.add(ans);
                   //Now move to the next position of i and j because we need to take unique elements
                    j++;
                    k--;
                    //now j and k also should be unique, we need to consider unique element so that we need to move this j and k to the next unique element position
                    //Move j until if arr[j]!arr[j-1]
                    while(j<k && arr[j]==arr[j-1]){
                        j++;
                    }
                    //Move k until if arr[k]!arr[k-1]
                    while(j<k && arr[k]==arr[k-1]){
                        k--;
                    }
                }
            }

        }
        return result;

    }

}
