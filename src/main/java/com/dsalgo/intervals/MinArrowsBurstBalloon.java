package com.dsalgo.intervals;

import java.util.Arrays;

/**
 * The Minimum Arrows to Burst Balloons problem is a classic greedy problem where you need to figure out the minimum number of arrows required to burst all balloons.
 * The key challenge is that each balloon has a range, and you can burst multiple balloons with a single arrow if their ranges overlap.
 */
public class MinArrowsBurstBalloon {

    /**
     * 	1.	Sort the balloons by their end positions.
     * 	2.	Initialize a counter arrows = 1 (because you always need at least one arrow).
     * 	3.	Set the first arrow position to the end of the first balloon.
     * 	4.	Iterate over the sorted balloons:
     * 	•	If a balloon starts after the current arrow’s position, shoot a new arrow and update the arrow’s position to the end of the current balloon.
     * @param points
     * @return
     */
    public int findMinArrowShots(int[][] points) {

        if(points.length==0){
            return 0;
        }

        //Now sort the array with end positions
        Arrays.sort(points,(a,b) -> Integer.compare(a[1],b[1]));

        int arrows=1; // Shoot the array last position
        int lastPosition=points[0][1];
        for(int i=1;i<points.length;i++){

            //Checking the next starting point after the last position we shot the arrow
            if(points[i][0]>lastPosition){
                arrows++;
                //Now update the last position
                lastPosition=points[i][1];
            }

        }
        return arrows;
    }

    public static void main(String[] args) {
        MinArrowsBurstBalloon minArrowsBurstBalloon =new MinArrowsBurstBalloon();
        System.out.println("Min no of Arrows to Burst:"+
                minArrowsBurstBalloon.findMinArrowShots(new int[][]{{10,16},{2,8},{1,6},{7,12}}));
    }
}
