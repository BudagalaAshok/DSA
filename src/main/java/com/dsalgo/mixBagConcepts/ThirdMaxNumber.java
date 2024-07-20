package com.dsalgo.mixBagConcepts;

import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class ThirdMaxNumber {

    public int thirdMax(int[] nums) {

        Arrays.sort(nums);
        Arrays.asList(nums);
        List<Integer> valueSet = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!valueSet.contains(nums[i])) {
                valueSet.add(nums[i]);
            }
        }
        if (valueSet.size() == 2 || valueSet.size() == 1) {
            return valueSet.get(0);
        } else {
            return valueSet.get(2);
        }
        //[4,3,2,7,8,2,3,1]

        //[1,2,2,3,3,4,7,8]


    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> missingNumbers = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] != i) {
                nums[i - 1] = i;
            }
        }
        return missingNumbers;

    }

    public List<Integer> findDisappearedNumberSecondSolution(int[] nums) {

        // Iterate over each of the elements in the original array
        for (int i = 0; i < nums.length; i++) {

            // Treat the value as the new index
            int newIndex = Math.abs(nums[i]) - 1;

            // Check the magnitude of value at this new index
            // If the magnitude is positive, make it negative
            // thus indicating that the number nums[i] has
            // appeared or has been visited.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<Integer>();

        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }

    public int findMaxElementInArray(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        System.out.println("Max Element is :" + max);
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ThirdMaxNumber thirdMaxNumber = new ThirdMaxNumber();
        // System.out.println("Third Max Number :" + thirdMaxNumber.thirdMax(new int[]{3,2,1}));
        //thirdMaxNumber.findMaxElementInArray(new int[]{-2,-19,15,8,4});
        //thirdMaxNumber.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        thirdMaxNumber.findDisappearedNumberSecondSolution(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
    }
}
