package com.dsalgo.arrays;

import java.util.Arrays;

public class MinArrowsBurstBalloon {
    public int findMinArrowShots(int[][] points) {

        if(points.length==0){
            return 0;
        }

        //Now sort the array with end positions
        Arrays.sort(points,(a, b) ->Integer.compare(a[1],b[1]));

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
