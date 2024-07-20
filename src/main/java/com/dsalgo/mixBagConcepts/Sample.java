package com.dsalgo.mixBagConcepts;

import java.util.Arrays;
import java.util.Scanner;

public class Sample {

    public long findSum(long[] nums){
        long sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        return sum;

    }

    public int[] concatenateArray(int[] arr,int n){
        int[] duplicateArray=new int[n+n];

        for(int i=0;i<arr.length;i++){
            duplicateArray[i]=arr[i];
            duplicateArray[i+n]=arr[i];
        }

        return duplicateArray;

    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */

        /*Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of array elements");
        int n=sc.nextInt();
        long[] arr=new long[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
        }*/

        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        Sample main=new Sample();
        System.out.println(Arrays.toString(main.concatenateArray(arr,n)));

    }
}
