package com.dsalgo.binarySearch;

public class MinDaysToMakeBouquetsUsingBS {

    public static int minNoOfDaysToMakeBouquet(int[] arr, int flowers, int bouqets) {

        //Let say we need to make 3 bouquets with two different flowers then we need 3*2 i.e 6 flowers
        //In our garden we have only three flowers then we can't make so check condition before proceeding further
        if ((flowers * bouqets) > arr.length) {
            return -1;
        }

        //Now find the min flower to make bloom and max flow to take bloom;
        //Low is the min time taken a flower to bloom and high is the max time taken to bloom a flower
        int low = arr[0];
        int high = arr[0];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < low) {
                low = arr[i];
            }
            if (arr[i] > high) {
                high = arr[i];
            }
        }

        //Now we have low and high values
        int ans=-1;
        while (low <= high) {

            int mid = (low + high) / 2;
            //Wit these mid value i.e mid value represents the days to check the flowers are bloom to enough to make required bouquets
            if(isPossibleSolution(arr,mid,flowers,bouqets)){
                //If we found a possible solution then we need to minimize the no of days to make bouquets so reduce the mid value
                ans=mid;
                high=mid-1;
            }else{
                //If we don't find with the mid value then we need to increment the days so increment the low for that
                low=mid+1;
            }
        }
        return ans;

    }

    private static boolean isPossibleSolution(int[] arr, int mid, int flowers, int bouquets) {

        int adjCount=0;//To count the adjacent flowers
        int bCount=0;//To count the bouquets we make up to now with mid value

        //Now find flowers in the garden with the mid days to make bouquets
        for (int i = 0; i < arr.length; i++) {

            //That means already flower got blown
            if(arr[i]<=mid){
                adjCount++;
                if(adjCount==flowers){
                    bCount++;
                    if(bCount==bouquets){
                        return true;
                    }
                    //Once we make a bouquet with adjacent flowers then reset the adjacent count to zero to check further solution
                    adjCount=0;
                }
            }else{
                //Here again resetting the adjacent count as well let say previous flower was bloomed and then next flower does not bloom in this case,
                //no use of to make bouquet so resetting to zero again
                adjCount=0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] gardenWithFlowers=new int[]{2,5,2,9,2,10,4,6,5,6};
        int boq=4;
        int flowers=2;
        System.out.println("Min No Of days to make required bouquets was :"+minNoOfDaysToMakeBouquet(gardenWithFlowers,flowers,boq));
    }

}
