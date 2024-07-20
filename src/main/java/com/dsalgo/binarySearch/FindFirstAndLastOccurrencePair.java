package com.dsalgo.binarySearch;

public class FindFirstAndLastOccurrencePair {


    public static int getFirstOccurrenceOfElement(int[] arr, int x){
        int low=0;
        int high=arr.length-1;
        int first=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x){
                first=mid;
                high=mid-1;
            }else if(arr[mid]<x){
                low=mid+1;
            }else{
                high=mid-1;
            }

        }
        return first;
    }

    public static int getLastOccurrenceOfElement(int[] arr, int x){
        int low=0;
        int high=arr.length-1;
        int last=-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==x){
                last=mid;
                low=mid+1;
            }else if(arr[mid]<x){
                low=mid+1;
            }else{
                high=mid-1;
            }

        }
        return last;

    }


    public static void main(String[] args) {

        int[] arr=new int[]{0,1,1,5};
        int first=getFirstOccurrenceOfElement(arr,1);
        if(first==-1){
            System.out.println("Not found");
        }
        int last=getLastOccurrenceOfElement(arr,1);
        System.out.println("First Occurrence was at position :"+first+" and last occurrence was at position :"+last);
        System.out.println("Count no of occurrences was :"+(last-first+1));

    }


}
