package com.dsalgo.dp;

public class FrogJump {


    public static void findMinEnergyConsumed(int[] heights){

        int n=heights.length;
        int[] dp=new int[n];

        //To stay at wherever we are standing no energy was needed
        dp[0]=0;

        for (int i = 1; i < n; i++) {
            //Frog can come from either before step (i-1) or before to before step i.e (i-2)
           int jumpOne=dp[i-1]+Math.abs(heights[i]-heights[i-1]);
           int jumpTwo=i>1 ? dp[i-2]+Math.abs(heights[i]-heights[i-2]) : Integer.MAX_VALUE;
           dp[i]=Math.min(jumpOne,jumpTwo);
        }

        // The result will be the minimum energy to reach the last stone
        System.out.println("Minimum Energy required to reach the last stone :"+ dp[n-1]);

    }


    public static void findMinEnergyConsumedWithSpaceOptimized(int[] heights){

        int n=heights.length;
        int[] dp=new int[n];

        //To stay at wherever we are standing no energy was needed
       int prev1=0;
       int prev2=0;

        for (int i = 1; i < n; i++) {
            int curr=0;
            //Frog can come from either before step (i-1) or before to before step i.e (i-2)
            int jumpOne=prev1+Math.abs(heights[i]-heights[i-1]);
            int jumpTwo=i>1 ? prev2+Math.abs(heights[i]-heights[i-2]) : Integer.MAX_VALUE;
            curr=Math.min(jumpOne,jumpTwo);
            prev2=prev1;
            prev1=curr;
        }

        // The result will be the minimum energy to reach the last stone i.e prev1
        System.out.println("Minimum Energy required to reach the last stone :"+ prev1);

    }

    public static void main(String[] args) {

        int[] heights={10,30,40,20};
        findMinEnergyConsumed(heights);
        findMinEnergyConsumedWithSpaceOptimized(heights);

    }

}
