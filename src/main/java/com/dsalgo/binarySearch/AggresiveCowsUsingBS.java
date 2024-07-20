package com.dsalgo.binarySearch;

public class AggresiveCowsUsingBS {
    //Need to place the cows between the stalls and find the largest minimum distance between all the combinations
    //Stalls can be any order so better we can do sorting(ascending order)
    public static int findMinimumDistance(int[] stalls, int cows) {

        //Find low and high, low is at 1 and high is distance between the first cow and the last cow under the stalls
        //Assuming arrays was sorted
        int low = 1;
        int n = stalls.length;
        int high = stalls[n - 1] - stalls[0];
        int ans=-1;

        if(cows>n){
            return -1;
        }

        while (low <= high) {

            int mid = (low + high) / 2;
            if (canPlaceCow(stalls, mid,cows)) {
                //If mid is possible solution then we need to find the largest min distance
                //If we are place the cow in the position then we need to go right to find the max distance then increasing low
                ans=mid;
                low=mid+1;

            }else{
                //If we are not able to place the cows with distance provided then we reduce the distance between the stalls
                high=mid-1;
            }

        }
        return ans;
    }

    private static boolean canPlaceCow(int[] stalls, int distance, int cows) {

        //Place cow at starting position of stall so initializing cow to 1
        int cow=1;
        int prevPlacedCowPosition=stalls[0];
        for(int i=1;i<stalls.length;i++){

            //Now find the distance between two stalls is equal or greater than distance, so here storing earlier placed cow position
            // and calculating with the each stall
            if(stalls[i]-prevPlacedCowPosition>=distance){
                cow++;
                prevPlacedCowPosition=stalls[i];
            }

            if(cow==cows){
                return true;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] stalls=new int[]{1,2,4,8,9};
        int cows=3;
        System.out.println("Find largest of minimum Distance Placed between the cows :"+findMinimumDistance(stalls,cows));

    }

}
