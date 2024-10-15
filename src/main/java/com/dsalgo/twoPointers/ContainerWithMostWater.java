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

    //Bruteforce solution TC:O(n^2)
    public int maxArea(int[] height) {
        int maxArea = 0;

        // Brute-force approach: check every possible pair of lines
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                // Find the height as the minimum of the two lines
                int h = Math.min(height[i], height[j]);
                // Width is the distance between the two lines
                int w = j - i;
                // Calculate the area and update maxArea
                int area = h * w;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

}
