package com.dsalgo.mixBagConcepts;

import java.util.Arrays;

import static java.lang.Math.abs;

public class PrintPermutationOfAnArray {

   public static int ans=Integer.MAX_VALUE;
    public static void printPermutations(int[] perm, int[] arr, boolean[] used, int idx, int n) {

        if (idx == n) {
            //Check that array is super square matrix
            //If it is super square matrix then calculate cost with the input array
            if(checkIfItSuperSquareMatrix(perm,arr)){
                System.out.println(Arrays.toString(perm));
                ans=Math.min(ans,costOfArrayWithRespectToSquareMatrix(perm,arr));
            }
        }

        for (int i = 0; i < n; i++) {

            if(!used[i]){
                perm[idx]=arr[i];
                used[i]=true;
                printPermutations(perm,arr,used,idx+1,n);
                used[i]=false;
            }
        }
    }

    /*
     0 1 2
     3 4 5
     6 7 8
     */

    //TODo now generate super square matrix after generating permutation

    public static boolean checkIfItSuperSquareMatrix(int[] arr, int[] ipArray){
        return checkRowSum(arr) && checkColumSum(arr) && checkDiagonalSum(arr);
    }

    public static int costOfArrayWithRespectToSquareMatrix(int[] arr,int[] ipArray){
       return abs(ipArray[0]-arr[0])+abs(ipArray[1]-arr[1])+abs(ipArray[2]-arr[2])+abs(ipArray[3]-arr[3])+
                abs(ipArray[4]-arr[4])+abs(ipArray[5]-arr[5])+abs(ipArray[6]-arr[6])+abs(ipArray[7]-arr[7])+
        abs(ipArray[8]-arr[8]);
    }

    private static boolean checkRowSum(int[] arr){
        return arr[0]+arr[1]+arr[2]==15 && arr[3]+arr[4]+arr[5]==15 && arr[6]+arr[7]+arr[8]==15;
    }

    private static boolean checkColumSum(int[] arr){
        return arr[0]+arr[3]+arr[6]==15 && arr[1]+arr[4]+arr[7]==15 && arr[2]+arr[5]+arr[8]==15;
    }

    private static boolean checkDiagonalSum(int[] arr){
        return arr[0]+arr[4]+arr[8]==15 && arr[2]+arr[4]+arr[6]==15;
    }

    public static void main(String[] args) {
        int n=9;
        int[] perm=new int[n];
        int[] arr=new int[]{4,2,3,1,9,6,7,8,5};
        boolean[] used= new boolean[n];
        System.out.println("For n value :"+n+" we will get factorial permutations :");
        printPermutations(perm,arr,used,0,n);
        System.out.println("Minimum Cost was to find the Super Square matrix is :"+ans);
    }

}
