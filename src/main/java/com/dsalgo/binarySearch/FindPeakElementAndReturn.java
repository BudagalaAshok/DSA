package com.dsalgo.binarySearch;

public class FindPeakElementAndReturn {


    public int findPeakElementUsingBS(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        //Here we are searching for peak and we can do search on left or right hand side and after search finishes whenever left and right meet the same point that is our peak element
        // so doing this
        while (left < right) {
            int mid = left + (right - left) / 2;

            //This means we are checking the neighbor and decided it is increasing slope so our peak element exists
            // at right hand side, so continuing our search at right hand side
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                //This is decreasing slope and our current element is less than neighbor element so in that case that is the peak element or may be on the left hand side
                right = mid;
            }

        }
        //Both points to the same position so return left or right is fine
        return left;
    }

}
