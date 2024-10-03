package com.dsalgo.backTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * <p>
 * You may return the answer in any order.
 * <p>
 * Time complexity: Since we explore all possible combinations, the time complexity is O(C(n, k)), where C(n, k) denotes the binomial coefficient or the number of ways to choose k elements from n elements (n choose k).
 * Space complexity: The space complexity is O(k) as we use an additional space to store the combination.
 */

//ToDo Combination Sum II Duplicate
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        dfs(n, k, 1, currentList, result);
        return result;
    }

    private void dfs(int n, int k, int start, List<Integer> currentList, List<List<Integer>> result) {
        //Base case
        if (currentList.size() == k) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        //here why we are going to the last index because we need to consider the last element as well
        for (int i = start; i <= n; i++) {
            currentList.add(i);
            //Moving to the next index for the next combination
            dfs(n, k, i + 1, currentList, result);
            //Back tracking by removing the previous added character
            currentList.remove(currentList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }

}
