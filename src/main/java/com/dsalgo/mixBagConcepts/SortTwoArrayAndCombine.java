package com.dsalgo.mixBagConcepts;

import java.util.Arrays;

public class SortTwoArrayAndCombine {

    //If elements are not sorted we can't use the two pointer technique in that case still we can use that technique but need to traverse from last index of the two arrays
    public static void sortTwoArraysCombine(int[] arr1, int[] arr2, int m, int n) {
        int pointer2 = m - 1;
        int k = n - 1;
        int pointer1 = n - m - 1;

        while(pointer1>=0 && pointer2>=0){
            if(arr1[pointer1]>arr2[pointer2]){
                arr1[k]=arr1[pointer1];
                k--;
                pointer1--;
            }else{
                arr1[k]=arr2[pointer2];
                k--;
                pointer2--;
            }
        }
        while(pointer1>=0){
            arr1[k]=arr1[pointer1];
            k--;
            pointer1--;
        }

        while(pointer2>=0){
            arr1[k]=arr2[pointer2];
            k--;
            pointer2--;
        }

        System.out.println(Arrays.toString(arr1));

    }

    //solve problems for selection and insert sort and submit

    public static void main(String[] args) {

        int[] arr1=new int[]{3,5,12,18,35,0,0,0,0,0,0,0,0};
        int[] arr2=new int[]{-1,2,5,7,10,12,15,17};
        sortTwoArraysCombine(arr1,arr2,8,13);

    }

}
