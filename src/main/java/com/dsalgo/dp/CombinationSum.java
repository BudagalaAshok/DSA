package com.dsalgo.dp;

import java.util.ArrayList;
import java.util.List;

//This problem can be solved using recursion and backtracking by considering the scenario pick and non-pick
//here the same number can be considered multiple times to find the combination
public class CombinationSum {

    private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        //Base condition is there if he reaches the end of the array and at that time our targe is zero then we can consider that combination otherwise ignore
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        //checking the element we are picking under the array is always less than the target
        if (arr[ind] <= target) {
            //If we are picking add that element to our list
            ds.add(arr[ind]);
            //Then we are reducing that element from target because we are picking that element
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            //Once if we found invalid combination/valid combination then we need to backtrack and find another solution so whatever the element we added we need to remove it from list
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
