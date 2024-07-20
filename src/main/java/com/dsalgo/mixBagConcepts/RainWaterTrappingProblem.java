package com.dsalgo.mixBagConcepts;

import java.util.Stack;

public class RainWaterTrappingProblem {


    public static int findTotalAmountOfWaterTrapped(int[] heights) {

        //Incase we have only one height or two height bars also we can't store any water
        if (heights.length == 1 || heights.length == 2) {
            return 0;
        }

        //Left and right bars also not store any water in those between bars only we can store water
        //Minimum 3 buildings should be there to store water
        //Ascending order of 3 blocks should not store water in the same way descending order of 3 blocks also does not store water ?
        //first and last bar does not store any water so we are going from 1 to second last element
        int res=0;
        for (int i = 1; i <= heights.length - 2; i++) {

            int lb=heights[i];
            int ub=heights[i];
            //find the left side what was the tallest bar up to ith position
            for (int j = 0; j < i; j++) {
                lb=Math.max(lb,heights[j]);
            }

            //find the right side what was the tallest bar from ith position
            for (int j = i+1; j < heights.length; j++) {
                ub=Math.max(ub,heights[j]);
            }

            //Now calculating water level based on lower and upper bound. Whatever is the minimum we can store that many water only
            int wl=Math.min(lb,ub);
            //To find trapped water, we need to do water level - height of the current building
            int trappedWater=wl-heights[i];
            res+=trappedWater;
        }

        return res;

    }

    //Optimized approach for Rain water Trapping Problem
    //For this precompute what was the left most highest bar and right most highest bar and store in two arrays
    //one is lb and one is rb

    //Here space complexity is 0(n) and time complexity is O(n) --> is there any way we can reduce to O(1) ?
    public static int findTrappingWaterWithOptimizedApproach(int[] heights){

        int n=heights.length;
        int[] lb=new int[n];
        int[] rb=new int[n];

        //Precompute left highest bar and store in lb array for each bar
        lb[0]=heights[0];
        for (int i = 1; i <n-1 ; i++) {
            lb[i]=Math.max(heights[i],lb[i-1]);
        }

        //PreCompute right highest bar and store in rb array for each bar
        rb[n-1]=heights[n-1];
        for (int i = n-2; i >=0 ; i--) {
            rb[i]=Math.max(heights[i],rb[i+1]);
        }

        int res=0;
        for (int i = 1; i <n-1 ; i++) {

            int trappedWater=Math.min(lb[i],rb[i])-heights[i];
             res+=trappedWater;
        }

        return res;

    }


    //Here we can solve using two pointer technique as well here with out space and time complexity is O(n)
    public static int calculateTrappedWaterWithTwoPointer(int[] heights){

        int lhb=heights[0];
        int rhb=heights[heights.length-1];
        int l=0;
        int r=heights.length-1;
        int res=0;
        while(l<=r){

            if(lhb<=rhb){

                if(heights[l]>=lhb){
                    lhb=heights[l];
                }else{
                 res+=lhb-heights[l];
                }
               l++;
            }else{
                 if(heights[r]>=rhb){
                     rhb=heights[r];
                 }else{
                     res+=rhb-heights[r];
                 }
                r--;
            }

        }
        return res;
    }

    public static int calculateTrappedWaterUsingStack(int[] heights){

        if(heights==null | heights.length==1 || heights.length==2){
            return 0;
        }

        Stack<Integer> waterStack=new Stack<>();
        int waterTrapped=0;
        for(int i=0;i<heights.length;i++){

            while(!waterStack.isEmpty() && heights[i]>heights[waterStack.peek()]){

                int top=waterStack.pop();
                if(waterStack.isEmpty()){
                    break;
                }
                int distance=i-waterStack.peek()-1;
                int bounded_height=Math.min(heights[i],heights[waterStack.peek()])-heights[top];
                waterTrapped+=distance*bounded_height;
            }

            waterStack.push(i);

        }

        return waterTrapped;


    }

    public static void main(String[] args) {
        //System.out.println("Find Total Amount of Trapped :"+findTotalAmountOfWaterTrapped(new int[]{4,2,0,3,2,5}));
        //System.out.println("Find Total Amount of Trapped with Optimized Solution :"+findTrappingWaterWithOptimizedApproach(new int[]{4,2,0,3,2,5}));
        //System.out.println("Optimized approach with out using space :"+calculateTrappedWaterWithTwoPointer(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println("Optimized approach with using stack :"+calculateTrappedWaterUsingStack(new int[]{4,2,0,3,2,5}));
    }

}
