package com.dsalgo.mixBagConcepts;

//With out using Binary search
public class FindMedianOfTwoSortedArrays {


    //Time complexity was O(n+m)
    //But we need to solve O(log(m+n))
    public static float findMedianOfTwoSortedArrays(int[] arr1, int[] arr2, int n, int m) {

        //Now merge these two sorted arrays with two pointers and then final array is also sorted array

        int[] finalArray = new int[n + m];
        int p1 = 0;
        int p2 = 0;
        int k = 0;
        int mid = (n + m) / 2;
        //Here after finding the median value in the final array we don't have any use of elements after median so adding below condition
        //k is up to mid value
        //Adding below while loops also because few elements are left in the array when p1< n or p2<m conditions fails
        while (p1 < n && p2 < m && k<=mid) {

            if (arr1[p1] < arr2[p2]) {
                finalArray[k] = arr1[p1];
                p1++;
                k++;
            } else {
                finalArray[k] = arr2[p2];
                p2++;
                k++;
            }
        }
        //Above loop was done then we have some remaining element left in array1 or array2 so copying those
        while (p1 < n && k<=mid) {
            finalArray[k] = arr1[p1];
            p1++;
            k++;
        }

        while (p2 < m && k<=mid) {
            finalArray[k] = arr2[p2];
            p2++;
            k++;
        }

        //Now our final array is sorted with the two arrays
        //find the mid value and then if it is even do (n+1)/2 or (mid + mid-1)/2
        if (mid % 2 == 0) {
            return finalArray[mid];
        } else {
            return (float)(finalArray[mid] + finalArray[mid - 1]) / 2;
        }

    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 8, 17};
        int[] arr2 = {5, 6, 7, 19, 21, 25};
        System.out.println("Median was :"+findMedianOfTwoSortedArrays(arr1, arr2, 4, 6));
    }

}
