package com.dsalgo.binarySearch;

public class PaintJobsDistributionWithBS {


    //10,20,30,40,50
    //Painter job assignment problem using BS

    /**
     * We are distributing the paints jobs effectively among each painter and finding minimum amount of units it takes by using BS
     * Here high value is calculating by adding all the jobs under that array that is our high value
     * And low value is 0 after that calculating mid value and proceed
     * @param arr
     * @param painters
     * @param units
     * @return
     */

    public static int printMinimumDistributionPaintJob(int[] arr, int painters, int units) {

        int low = 0;
        int high = 0;
        for (int number : arr) {
            high += number;
        }
        int ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            //Here checking based on the mid value the partition is valid or not based on the painters available
            if (isValidPartition(arr, mid, painters)) {
                high = mid - 1;
                ans = mid;
            } else {
                low = mid + 1;
            }

        }

        return ans * units;


    }

    private static boolean isValidPartition(int[] arr, int mid, int painters) {

        //Check pbc count is less than mid value then we can assign the work to that painter
        //If we assigned enough work then get the new painter
        int pbc = 0;
        int painter = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid) {
                return false;
            }
            if (pbc + arr[i] <= mid) {
                pbc += arr[i];
            } else {
                painter++;
                if (painter > painters) {
                    return false;
                }
                pbc = arr[i];
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(printMinimumDistributionPaintJob(new int[]{10, 20, 30, 40}, 2, 2));
    }


}
