package com.dsalgo.mixBagConcepts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Math.abs;

public class PrintPermutationOfAnList {

    public static int ans = Integer.MAX_VALUE;

   /* public static void printPermutations(List<List<Integer>> perm, List<List<Integer>> arr, boolean[] used, int idx, int n) {

        if (idx == n) {
            //Check that array is super square matrix
            //If it is super square matrix then calculate cost with the input array
            if (checkIfItSuperSquareMatrix(perm)) {
                System.out.println(perm);
                ans = Math.min(ans, costOfArrayWithRespectToSquareMatrix(perm, arr));
            }
        }

        for (int i = 0; i < n; i++) {

            if (!used[i]) {
                perm[idx] = arr[i];
                used[i] = true;
                printPermutations(perm, arr, used, idx + 1, n);
                used[i] = false;
            }
        }
    }*/

    /*
     0 1 2
     3 4 5
     6 7 8
     */

    //TODo now generate super square matrix after generating permutation

    public static boolean checkIfItSuperSquareMatrix(List<List<Integer>> permList) {
        return checkRowSum(permList) && checkColumSum(permList) && checkDiagonalSum(permList);
    }

    public static int costOfArrayWithRespectToSquareMatrix(List<List<Integer>> permList, List<List<Integer>> ipList) {
        List<Integer> permListFirstRow = permList.get(0);
        List<Integer> permListSecondRow = permList.get(1);
        List<Integer> permListThirdRow = permList.get(2);
        List<Integer> ipListFirstRow=ipList.get(0);
        List<Integer> ipListSecondRow=ipList.get(1);
        List<Integer> ipListThirdRow=ipList.get(2);
        return abs(ipListFirstRow.get(0) - permListFirstRow.get(0)) + abs(permListFirstRow.get(1) - ipListFirstRow.get(1)) + abs(permListFirstRow.get(2) - ipListFirstRow.get(2))
                + abs(ipListSecondRow.get(0) - permListSecondRow.get(0)) + abs(ipListSecondRow.get(1) - permListSecondRow.get(1)) + abs(ipListSecondRow.get(2) - permListSecondRow.get(2)) +
                abs(ipListThirdRow.get(0) - permListThirdRow.get(0)) +  abs(ipListThirdRow.get(1) - permListThirdRow.get(1)) +
                abs(ipListThirdRow.get(2) - permListThirdRow.get(2));
    }

    private static boolean checkRowSum(List<List<Integer>> permList) {
        return permList.get(0).get(0) + permList.get(0).get(1) + permList.get(0).get(2) == 15
                && permList.get(1).get(0) + permList.get(1).get(1) + permList.get(1).get(2) == 15
                && permList.get(2).get(0) + permList.get(2).get(1) + permList.get(2).get(2) == 15;
    }

    private static boolean checkColumSum(List<List<Integer>> permList) {
        return permList.get(0).get(0) + permList.get(1).get(0) + permList.get(2).get(2) == 15
                && permList.get(0).get(1) + permList.get(1).get(1) + permList.get(2).get(1) == 15
                && permList.get(0).get(2) + permList.get(1).get(2) + permList.get(2).get(3) == 15;
    }

    private static boolean checkDiagonalSum(List<List<Integer>> permList) {
        return permList.get(0).get(0) + permList.get(1).get(1) + permList.get(2).get(2) == 15
                && permList.get(0).get(2) + permList.get(1).get(1) + permList.get(2).get(0) == 15;
    }

    public static void main(String[] args) {
        int n = 9;
        List<List<Integer>> permutations = new ArrayList<>();
        List<List<Integer>> inputList = new ArrayList<>();
        List<Integer> firstRow=new ArrayList<>();
        firstRow.add(1);firstRow.add(2);firstRow.add(3);
        List<Integer> secondRow=new ArrayList<>();
        secondRow.add(4);secondRow.add(5);secondRow.add(6);
        List<Integer> thirdRow=new ArrayList<>();
        thirdRow.add(7);thirdRow.add(8);thirdRow.add(9);
        inputList.add(firstRow);inputList.add(secondRow);
        inputList.add(thirdRow);
        boolean[] used = new boolean[n];
        System.out.println("For n value :" + n + " we will get factorial permutations :");
        //printPermutations(permutations, inputList, used, 0, n);
        System.out.println("Minimum Cost was to find the Super Square matrix is :" + ans);
    }

}
