package com.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Random;

public class JumpGameII {

    public int minJumps(int[] jumps) {

        int l = 0;
        int r = 0;
        int n = jumps.length;
        int totalJumps = 0;
        //Until If we cross the last index of our jump array
        while (r < n - 1) {
            int farthest = 0;
            //Need to find the further farthest range by using current left and right ranges
            for (int i = l; i <= r; i++) {
                farthest = Math.max(i + jumps[i], farthest);
            }
            //Once done update the left and right ranges again
            //Left becames right+1 and right becames next farthest
            l = r + 1;
            r = farthest;
            totalJumps++;
        }
        return totalJumps;
    }

    public int minJumpsAnotherApproach(int[] jumps){
        int jumpsCount=0;
        int farthestReachable=0;
        int currentJumpEnd=0;
        for (int i = 0; i < jumps.length; i++) {

            //Calculating how much far we can go from current position
            farthestReachable=Math.max(farthestReachable,i+jumps[i]);

            if(i==currentJumpEnd){
                jumpsCount++;
                currentJumpEnd=farthestReachable; //setting the new range
            }

            // If the currentEnd is at or beyond the last index, we are done
            if(farthestReachable>=jumps.length-1){
                break;
            }

        }
        return jumpsCount;

    }

    public static void main(String[] args) {
        JumpGameII jumpGameII = new JumpGameII();
        System.out.println(jumpGameII.minJumps(new int[]{2, 3, 1, 1, 4}));
    }

}
