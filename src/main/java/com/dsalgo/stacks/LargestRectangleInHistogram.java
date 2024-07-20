package com.dsalgo.stacks;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public static int findMaxRectangleArea(int[] heights, int n){

        Stack<Integer> stack=new Stack<>();
        int[] leftSmall=new int[n];
        int[] rightSmall=new int[n];
        for (int i = 0; i < heights.length; i++) {

             while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                 stack.pop();
             }
             if(stack.isEmpty()){
                 leftSmall[i]=0;
             }else{
                 leftSmall[i]=stack.peek()+1;
             }
             stack.push(i);

        }
        while(!stack.isEmpty()){
            stack.pop();
        }

        //right Small
        for (int i = n-1; i >=0; i--) {

            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                rightSmall[i]=n-1;
            }else{
                rightSmall[i]=stack.peek()-1;
            }
            stack.push(i);
        }

        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,heights[i]*(rightSmall[i]-leftSmall[i]+1));
        }
        return max;

    }


    //Using Single pass we can find also max area of histogram
    public static int findAreaOfHistogram(int[] heights){

        Stack<Integer> stack=new Stack<>();
        int maxA=0;
        int n=heights.length;
        for (int i = 0; i <= n ; i++) {

            while(!stack.empty() && (i==n || heights[stack.peek()]>=heights[i])){
                int height =stack.peek();
                stack.pop();
                int width;
                if(stack.empty()){
                    width=i;
                }else{
                    width=i-stack.peek()-1;
                }
                maxA=Math.max(maxA,width*height);
            }
            stack.push(i);

        }
        return maxA;

    }

}
