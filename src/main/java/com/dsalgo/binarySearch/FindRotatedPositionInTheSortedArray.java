package com.dsalgo.binarySearch;


/**
 * Approach:
 * <p>
 * 1.	Identify the Pivot Point: The pivot is the index where the smallest element in the array resides. This can be found using a modified version of binary search.
 * 2.	Binary Search Logic:
 * •	Compare the middle element of the array with the element at the right end:
 * •	If the middle element is greater than the element at the right end, it means the pivot is to the right (since the smallest element lies in the rotated part).
 * •	If the middle element is less than or equal to the right element, it means the pivot is either the middle element itself or lies to the left (since the smallest element lies in the left sorted part).
 */
public class FindRotatedPositionInTheSortedArray {

    public int findRotatedPositionInSortedArray(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        //That means it is not rotated
        if (nums[left] <= nums[right]) {
            return 0;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            //Now check if mid is greater than mid+1 then mid+1 is the rotated index
            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            //Check before previous element is greater than mid then return mid because where the position got reversed
            if (nums[mid - 1] > nums[mid]) {
                return mid;
            }

            //So then it got rotated either left or right hand side of an array
            //Then it got rotated at right hand side so our search in on right hand side
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                //Our search is on left hand side
                right = mid - 1;
            }


        }

        //if not found rotated index then return 0

        return 0;

    }
}
