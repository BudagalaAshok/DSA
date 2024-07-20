package com.dsalgo.binarySearch;

public class SmallestDivisorForGivenThershold {

    public static int findSmallestDivisorForThreshold(int[] arr, int threshold) {

        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int eachWeight : arr) {
            high = Math.max(eachWeight, high);
        }

        int result=-1;
        //For any one of the binary case we can return low instead of takin another variable
        //Because low ends in opposite polarity it starts from not possible and end at possible solution
        while (low <= high) {
            int mid = (low + high) / 2;
            int thresoldValue = findThresholdValue(arr, mid);
            if (thresoldValue <= threshold) {
                result=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }


        }
        return result;

    }

    private static  int findThresholdValue(int[] arr, int mid) {

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {

            sum += (int) Math.ceil((double) arr[i] / mid);

        }
        return sum;

    }

    public static void main(String[] args) {

        int[] nums={1,2,5,9};
        int threshold=7;
        System.out.println(findSmallestDivisorForThreshold(nums,threshold));

    }


}
