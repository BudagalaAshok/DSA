package com.dsalgo.twoPointers;

public class ContainerWithMostWater {

    //We can solve the problem by using two pointers
    //Using this problem we can calculate the area like Min(left, right) * (right-left) --> width
    public int mostWaterContainer(int[] heights) {

        int p1 = 0;
        int p2 = heights.length - 1;
        int maxArea=0;
        while (p1 < p2) {

            int currentArea=Math.min(heights[p1],heights[p2])*(p2-p1);
            maxArea=Math.max(maxArea,currentArea);
            if(heights[p1]<heights[p2]){
                p1++;
            }else{
                p2++;
            }

        }

        return maxArea;
    }

}
