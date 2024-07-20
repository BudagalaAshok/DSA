package com.dsalgo.binarySearch;

public class SearchInRotatedSortedArrayWithDuplicates {

    public static boolean searchInRotatedSortedWithDuplicates(int[] arr,int target){

        int low=0;
        int high=arr.length-1;
        while(low<=high){

            int mid=(low+high)/2;
            if(arr[mid]==target) {
                return true;
            }
                //If there are duplicates we need to handle this scenario specifically
            if(arr[low]==arr[mid] && arr[mid]==arr[high]){
                    //Here we are shrinking and continuing the search
                    low++;
                    high--;
                    continue;
            }
            else if(arr[low]<=arr[mid]){

                if(arr[low]<=target && target<=arr[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }

            }else{

                if(arr[mid]<=target && target<=arr[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }

        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println("Element exists :"+searchInRotatedSortedWithDuplicates(new int[]{4,5,6,1,2,2,3,3},3));
    }

}
