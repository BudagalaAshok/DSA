package com.dsalgo.strings;

import java.util.Scanner;

public class SumOfSubArrays {
    public static int[] calculatePrefixSum(int[] arr){

        //First store the prefix sum in to array by taking extra space
        int[] ps=new int[arr.length];
        ps[0]=arr[0];
        for(int k=1;k<ps.length;k++){
            ps[k]=ps[k-1]+arr[k];
        }

        return ps;

    }

    public static int findSumOfSubArrays(int[] prefixSum,int[] arr, int i, int j){
        return prefixSum[j]-prefixSum[i]+arr[i];
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc=new Scanner(System.in);
        int length=sc.nextInt();
        int[] arr=new int[length];
        for(int i=0;i<length;i++){
            arr[i]=sc.nextInt();
        }
        int queries=sc.nextInt();
        int[] prefixSum=calculatePrefixSum(arr);
        for(int j=0;j<queries;j++){
            int firstIndex=sc.nextInt();
            int secondIndex=sc.nextInt();
            System.out.println(findSumOfSubArrays(prefixSum,arr,firstIndex,secondIndex));
        }
    }
}
