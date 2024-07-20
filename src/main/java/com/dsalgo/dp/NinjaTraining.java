package com.dsalgo.dp;

public class NinjaTraining {


    public static void findMaxPointsEarned(int[][] points,int n){

        //create and initialize DP array with first day points
        int[][] dp=new int[n][3];
        for(int i=0;i<n;i++){
            dp[0][i]=points[0][i];
        }
        //From second day iterate the remaining points 2d array and then calculate the max by excluding the current day
        // activity in previous day activities

        for(int i=1;i<n;i++){

            dp[i][0]=points[i][0]+Math.max(dp[i-1][1],dp[i-1][2]);
            dp[i][1]=points[i][1]+Math.max(dp[i-1][0],dp[i-1][2]);
            dp[i][2]=points[i][2]+Math.max(dp[i-1][0],dp[i-1][1]);

        }

        //Now calculate the max of the last day ativities
        System.out.println(Math.max(dp[n-1][0],Math.max(dp[n-1][1],dp[n-1][2])));


    }

    //Optimizing space by using current and prev 1D array to store previous and current values
    public static void findMaxPointsEarnedUsingOptimizedSpace(int[][] points,int n){

        //create and initialize DP array with first day points
        int[] curr=new int[n];
        int[] prev=new int[n];
        for(int i=0;i<n;i++){
            prev[i]=points[0][i];
        }
        //From second day iterate the remaining points 2d array and then calculate the max by excluding the current day
        // activity in previous day activities

        for(int i=1;i<n;i++){

            curr[0]=points[i][0]+Math.max(prev[1],prev[2]);
            curr[1]=points[i][1]+Math.max(prev[0],prev[2]);
            curr[2]=points[i][2]+Math.max(prev[0],prev[1]);

            //Now copy current values to prev array for next iteration
            for(int j=0;j<n;j++){
                prev[j]=curr[j];
            }

        }

        //Now calculate the max of the last day activities,Here last is the prev array values
        System.out.println(Math.max(prev[0],Math.max(prev[1],prev[2])));


    }


    public static void main(String[] args) {
        int[][] points={
                {1, 2, 5},
                {3, 1, 1},
                {3, 2, 1}

        };
        findMaxPointsEarned(points,3);
        findMaxPointsEarnedUsingOptimizedSpace(points,3);
    }

}
