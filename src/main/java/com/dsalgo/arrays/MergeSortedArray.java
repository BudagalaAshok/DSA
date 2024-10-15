package com.dsalgo.arrays;

import java.util.Arrays;

public class MergeSortedArray {

    public static void mergeTwoSortedArray(int[] nums1,int m,int n, int[] nums2){

        int p1=m-1;
        int p2=n-1;
        int p=m+n-1;

        while(p1>=0 && p2>=0){

            if(nums1[p1]<nums2[p2]){
                nums1[p]=nums2[p2];
                p2--;
                p--;

            }
            else{
               nums1[p]=nums1[p1];
               p1--;
               p--;
            }
        }

        //For remaining elements in p2
        while(p2>=0){
            nums1[p1]=nums2[p2];
            p2--;
            p--;
        }

        System.out.println(Arrays.toString(nums1));

    }


    //Brute force copy the elements from nums2 to nums1 and then sort the array. It adds the complexity of sorting
    //O(m+n) due to merging of two arrays
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        //Iterate from backwards from both of the array and place the greater element at last position of nums1 array
        int i=m-1;
        int j=n-1;
        int k=m+n-1;

        while(j>=0){

            if(i>=0 && nums1[i]>nums2[j]){
                nums1[k--]=nums1[i--];
            }else{
                nums1[k--]=nums2[j--];
            }
        }

    }


    public static void main(String[] args) {
        //mergeTwoSortedArray(new int[]{1,2,3,0,0,0},3,2,new int[]{2,5,6});
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},2);
    }

}
