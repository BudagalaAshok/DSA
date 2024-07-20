package com.dsalgo.stacks;

import java.io.*;
import java.util.*;

public class StockSpanArray {

    public static void printStockArray(int[] arr, int n){

        Stack<Integer> stack1=new Stack<>();
        Stack<Integer> stack2=new Stack<>();
        int[] stockArray=new int[n];
        stockArray[0]=1;
        stack1.push(arr[0]);
        int count=1;
        for(int i=1;i<n;i++){
            if(arr[i]<stack1.peek()){
                stack1.push(arr[i]);
                stockArray[i]=1;
            }else{
                stack2.push(arr[i]);
                while(!stack1.isEmpty() && arr[i]>=stack1.peek()){
                    count++;
                    stack2.push(stack1.pop());
                }
                stockArray[i]=count;
                count=1;
                //Putting element back to stack1
                while(!stack2.isEmpty()){
                    stack1.push(stack2.pop());
                }

            }

        }
        for(int element:stockArray){
            System.out.print(element+" ");
        }
        System.out.println();


    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc=new Scanner(System.in);
        int noOfTestCases=sc.nextInt();
        for(int i=0;i<noOfTestCases;i++){
            int elements=sc.nextInt();
            int[] arr=new int[elements];
            for(int j=0;j<elements;j++){
                arr[j]=sc.nextInt();
            }
            printStockArray(arr,elements);
        }
    }
}
