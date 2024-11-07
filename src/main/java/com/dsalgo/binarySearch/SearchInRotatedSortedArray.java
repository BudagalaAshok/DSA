package com.dsalgo.binarySearch;

public class SearchInRotatedSortedArray {

    //{0,1,2,4,5,6,7} --> Sorted array but before passing your function at k index the array got rotated
    //Let say array got rotated at index 4 then the array becames {4,5,6,7,0,1,2}
    //Now let's find the rotated index

    public static int findRotatedIndexInSortedArray(int[] arr,int target){

       //Find low and high values
       int low=0;
       int high=arr.length-1;
       while(low<=high){
           int mid=(low+high)/2;
           if(arr[mid]==target){
               return mid;
           }
           //Now our element lies in left sorted array or right sorted array
           //Let say If our element lies in left sorted array we can check using below condition
           //Identify the sorted half in this problem, then perform the binary search
           //How we need to identify , Here we can assume always one side of the array was sorted?
           else if(arr[low]<=arr[mid]){
               //Here we will check one more condition to search on left sorted array, first element is less than target value and target is less than mid
               //with this condition we can check that element exists in left or right
               if(arr[low]<=target && target<=arr[mid]){
                   high=mid-1;
               }else{
                   low=mid+1;
               }

           }
           //Here that means our element present in right sorted array
           else{

               if(arr[mid]<=target && target<=arr[high]){
                   low=mid+1;
               }else{
                   high=mid-1;
               }

           }


       }
       return -1;
    }

    public static void main(String[] args) {
        System.out.println("Search Index was :"+ findRotatedIndexInSortedArray(new int[]{4,5,6,7,0,1,2},0));
    }

}
