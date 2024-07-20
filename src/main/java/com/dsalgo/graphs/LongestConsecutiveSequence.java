package com.dsalgo.graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {


    //Using Linear search TC:O(n to power of 2)
    public static int findLongestConsecutiveSequence(int[] arr) {

        //Because each element we taken of count 1
        int max = 1;
        for (int j : arr) {
            int count = 1;
            int x = j;
            while (linearSearch(arr, x)) {
                x += 1;
                count++;
            }
            max = Math.max(count, max);
        }
        return max;

    }

    private static boolean linearSearch(int[] arr, int x) {
        for (int j : arr) {
            if (j == x) {
                return true;
            }

        }
        return false;
    }


    //Optimal approach using sorting and comparing with the previous element if not exists then check for next consecutive elements
    //TC: O(nlogn) + O(n)
    public static int findLCUsingOptimalApproach(int[] arr) {

        //Now all the elements are in ascending order
        Arrays.sort(arr);
        int lastSmaller = Integer.MIN_VALUE;
        int longest = 1;
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - 1 == lastSmaller) {
                count += 1;
                lastSmaller = arr[i];
            }
            //This case occurs whenever we are starting the element and also if it is not an consecutive element
            else if (arr[i] != lastSmaller) {
                count = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(count, longest);

        }
        return longest;

    }


    //Optimal Approach using set data structure, first put all the elements into set and then find the x-1 exists if it is not found then this is starting number
    //Under we find x+1 we iterate and increment the count and find the longest length
    public static int findLCUsingSet(int[] arr, int n) {

        if (n == 0) {
            return 0;
        }
        int longest = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        for (int it:set) {
            if (!set.contains(it - 1)) {

                int x = it;
                int count = 1;
                while (set.contains(x + 1)) {

                    count++;
                    x += 1;
                }
                longest = Math.max(count, longest);
            }

        }
        return longest;
    }

    //int[] a = {100, 200, 1, 2, 3, 4}; Input we can use to test


}
