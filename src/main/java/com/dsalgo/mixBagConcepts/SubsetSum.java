package com.dsalgo.mixBagConcepts;

import java.util.Scanner;

public class SubsetSum {

    public static int findTargetWithSubset(int[] arr, int target) {

        int n = arr.length;
        int count = 0;
        for (int i = 0; i < (1 << n); i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {

                //i & (1 << j)) ==> we can do this as well here
                if (checkBit  (i,j)!= 0) {
                    sum += arr[j];
                }
            }
            if (sum == target) {
                count++;
            }

        }
        return count;

    }


    public static int checkBit(int num, int i) {

        return (num >> i) & 1;

    }

    public static String findSubSetWithSum(int[] arr,int target){

        int n=arr.length;
        String result="NO";
        for(int i=0;i<(1<<n);i++){
            int sum=0;
            for(int j=0;j<n;j++){

                if(checkBit(i,j)==1){
                    sum+=arr[j];
                }

            }
            if(sum==target){
                return "YES";
            }

        }
        return result;


    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int range=sc.nextInt();
        for(int i=0;i<range;i++){
            int target=sc.nextInt();
            int arrayRange=sc.nextInt();
            int[] arr=new int[arrayRange];
            for(int j=0;j<arrayRange;j++){
                arr[j]=sc.nextInt();
            }
            System.out.println(findSubSetWithSum(arr,target));
        }
        //System.out.println("Count of subsets with target value is :" + findTargetWithSubset(new int[]{1, 3, 5, 7}, 8));
    }

}
