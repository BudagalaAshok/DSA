package com.dsalgo.strings;

public class FindMaxSumOfSubArray {

    public static int findMaxSumOfSubArray(int[] arr){

        //-2,5,6,7
        int maxResult=-1;
        for (int i = 0; i < arr.length; i++) {

            int currentSum=0;
            currentSum+=arr[i];
            maxResult=Math.max(currentSum,maxResult);

        }

        return maxResult;

    }

    public static void findMaxSumOfSubArrayAndPrint(int[] arr){

        //-2,-5,6,7,-1

        int start=0;
        int end=0;
        int maxSum=Integer.MIN_VALUE;
        int maxSoFar=0;
        int s=0;

        //Kadane's algorithm
        for (int i=0;i<arr.length;i++){
            maxSoFar+=arr[i];
            if(maxSum<maxSoFar){
                maxSum=maxSoFar;
                start=s;
                end=i;
            }
            if(maxSoFar<0){
                maxSoFar=0;
                s=i+1;
            }

        }
        System.out.println("Max sum is :"+maxSoFar);
        System.out.println("Max Sub Array is :");
        for (int i = start; i <= end; i++) {
            System.out.println(arr[i]+ "");
        }


    }


    public static void main(String[] args) {
        System.out.println("Max Sum of Array :"+ findMaxSumOfSubArray(new int[]{-2,5,6,7}));
    }

}
