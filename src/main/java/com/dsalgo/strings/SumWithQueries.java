package com.dsalgo.strings;

import java.util.Arrays;
import java.util.Scanner;

public class SumWithQueries {
    public static int findSumWithQueries(int[] arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }

    public static void processArrayWithQueries(int[] arr,int i, int j, int x){
        //Add x to the i index
        arr[i]+=x;
        if(j+1<arr.length){
            arr[j+1]-=x;
        }
    }

    //1,6,-2,3
    //1,7,-2,3
    //1,8,6,9



    //Once all queries are done we need to find the sum of elements
    public static void calculateFinalArray(int[] arr){
        for(int i=1;i<arr.length;i++){
            arr[i]+=arr[i-1];
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        /*Scanner sc=new Scanner(System.in);
        int noOfTestCases=sc.nextInt();

        for(int i=0;i<noOfTestCases;i++){
            int elements=sc.nextInt();
            int[] arr=new int[elements];
            for(int j=0;j<elements;j++){
                arr[j]=sc.nextInt();
            }
            int queries=sc.nextInt();
            for(int k=0;k<queries;k++){
                int firstIndex=sc.nextInt();
                int secondIndex=sc.nextInt();
                int x=sc.nextInt();
                processArrayWithQueries(arr,firstIndex,secondIndex,x);
                calculateFinalArray(arr);
                System.out.println("Final Array :"+ Arrays.toString(arr));
                System.out.println(findSumWithQueries(arr));
            }
        }*/
        int[] arr=new int[]{1,5,-3,2,8};
        processArrayWithQueries(arr,1,3,1);
        processArrayWithQueries(arr,0,1,2);
        calculateFinalArray(arr);
        System.out.println("Sum was :"+findSumWithQueries(arr));

    }

}
