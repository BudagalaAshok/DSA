package com.dsalgo.binarySearch;

public class WoodCuttingBS {

    /**
     * Flipkart wood cutting Problem
     * Need to find the machineHeight where we can get the exact wood count or if we didn't find exact wood count then we need to
     * find minimum extra units of exact wood count
     * Here first find the maximum height of the tree and then apply binary sort on that tree
     **/

    public static int machineHeight(int[] arr, int target) {

        //Find max height of the tree in the given elements that is our high value
        int low = 0;
        int high = 0;
        //O(n)
        for (int number : arr) {
            if (number > high) {
                high = number;
            }
        }
        /** O(n log(high))
         The binary search iterates until low is not less than or equal to high.
         The number of iterations in the worst case would be log(high), where high is the maximum value in the array.
         **/
        while (low <= high) {
            int mid = (low + high) / 2;
            //Find the wood count based on the mid value, after that we are adjusting low and high values based on that
            int wc = getWoodCount(arr, mid);
            if (wc == target || low == mid) {
                return mid;
            } else if (wc > target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    /**
     * Here if any tree greater than mid value then only finding the extra units and adding and then return the value
     *
     * @param arr
     * @param mid
     * @return
     */
    public static int getWoodCount(int[] arr, int mid) {
        int wc = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > mid) {
                wc += arr[i] - mid;
            }
        }
        return wc;
    }

    public static void main(String[] args) {
        int[] h = {20, 15, 10, 17};
        System.out.println("Minimum Machine Height was :" + machineHeight(h, 7));

    }
}
