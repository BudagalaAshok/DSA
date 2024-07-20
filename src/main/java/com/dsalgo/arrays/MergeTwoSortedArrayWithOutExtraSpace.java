package com.dsalgo.arrays;

/*
  Using Gap theorem it comes from shell sort
 */
public class MergeTwoSortedArrayWithOutExtraSpace {

    public void mergeSortedArraysUsingGapTechnique(int[] arr1, int[] arr2, int n, int m) {
        int len = (n + m);
        int gap = (int) Math.ceil(len / 2);
        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < (n + m)) {

                //There are three case because we have two arrays here one is left(n) and another one is at right(m)
                //If left is on arr1 and right is on arr2
                // left          // right
                //[1, 2, 3, 4]  [6,7, 8, 9, 10]
                if (left < n && right >= n) {
                    //why right-n is because right is like gap value it does not start from 0 index of second array
                    swapIfGreater(arr1, arr2, left, right - n);
                }
                //arr2 both pointers are on right array
                else if(left>=n){
                    swapIfGreater(arr1,arr2,left-n,right-n);
                }
                //arr1 both pointers are on left array
                else{
                    swapIfGreater(arr1,arr2,left,right);
                }
                left++;right++;

            }
            if (gap == 1) {
                break;
            }
            gap = (int) Math.ceil(gap / 2);
        }

    }

    void swapIfGreater(int[] arr1, int[] arr2, int ind1, int ind2) {
        if (arr1[ind1] > arr2[ind2]) {
            int temp = arr1[ind1];
            arr1[ind1] = arr2[ind2];
            arr2[ind2] = temp;
        }

        double x=Math.pow(1,2);
        double y=Math.pow(2,2);
        if(x>y){

        }


    }

    //Now print the first array and second array
}
