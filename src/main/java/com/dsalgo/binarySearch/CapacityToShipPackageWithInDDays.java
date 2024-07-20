package com.dsalgo.binarySearch;

public class CapacityToShipPackageWithInDDays {


    public static int findCapacityOfShip(int[] arr, int days) {

        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int eachWeight : arr) {
            low = Math.max(eachWeight, low);
            high += eachWeight;
        }
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int totalNoOfDays=isPossibleWeight(arr,mid);
            if(totalNoOfDays<=days){
                ans=mid;
                high = mid - 1;
            }else{
                low=mid+1;
            }

        }
        return ans;

    }

    //[1,2,3,4,5,6,7,8,9,10]
    private static int isPossibleWeight(int[] arr, int mid) {

        int days = 1;
        int weightCount = 0;
        for (int i = 0; i < arr.length; i++) {

            if (weightCount + arr[i] > mid) {
                days++;
                weightCount = arr[i];
            }else{
                weightCount+=arr[i];
            }

        }

        return days;

    }

    public static void main(String[] args) {
        int[] weights=new int[]{1,2,3,1,1};
        int days=4;
        System.out.println(findCapacityOfShip(weights,days));
    }


}
