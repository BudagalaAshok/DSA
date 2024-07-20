package com.dsalgo.subSequence;

import java.util.*;

public class SumOfSubArrayPairsEqToK {


    //function to generate all subset of a given array
    public static List<Integer> findSubsetSum(int[] arr, int n) {
        List<Integer> res = new ArrayList<>();
        for (int mask = 0; mask < (1 << n); mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum+=arr[i];
                }
            }
            res.add(sum);
        }
        return res;
    }

    public static boolean minAbsDifference(int[] nums, int goal) {
        int n =nums.length;
        int mid = n / 2;
        int[] num1 = Arrays.copyOfRange(nums, 0, mid);
        int[] num2 = Arrays.copyOfRange(nums, mid, n);

        //Generated two sets for left and right
        List<Integer> set1 = findSubsetSum(num1, num1.length);
        List<Integer> set2 = findSubsetSum(num2, num2.length);

        //Sorting the set Y (set2) so later we can perform binarySearch
        Collections.sort(set2);

        for (int x : set1) {
            int r = goal - x;
            if(binarySearch(set2,r)){
                return true;
            }

        }
        return false;

    }

    public static void printStack(){
        Stack<String> stack=new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    private static boolean binarySearch(List<Integer> nums, int target) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums.get(mid) == target) {
                return true;
            } else if (nums.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        //System.out.println("SubSet Exists :"+minAbsDifference(new int[]{-4,8,5,25,-1,12},23));
        printStack();
    }
}
