package com.dsalgo.backTracking;

import java.util.ArrayList;
import java.util.List;

//ToDo Permutation II problem
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(0, nums, result);
        return result;
    }

    public void backTrack(int index, int[] nums, List<List<Integer>> result) {

        //Base case
        if (index == nums.length) {
            addToList(result, nums);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            backTrack(index + 1, nums, result);
            swap(i, index, nums);
        }

    }

    private void addToList(List<List<Integer>> result, int[] nums) {
        List<Integer> currentResult = new ArrayList<>();
        for (int num : nums) {
            currentResult.add(num);
        }
        result.add(new ArrayList<>(currentResult));
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        System.out.println(permutations.permute(new int[]{1, 2,3}));
    }

}
