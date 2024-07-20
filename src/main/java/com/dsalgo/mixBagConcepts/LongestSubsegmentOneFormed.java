package com.dsalgo.mixBagConcepts;

public class LongestSubsegmentOneFormed {


    public static void flipByKTimesToFormLongestOnes(int[] arr,int k){

        int ans=0;
        int count=0;
        int j=-1;
        for(int i=0;i<arr.length;i++){

            if(arr[i]==0){
                count++;
            }
            while(count>k){
                j++;
                if(arr[j]==0){
                    count--;
                }
            }


            int length=i-j;
            ans=Math.max(ans,length);
        }


        System.out.println(ans);


    }

    public static void main(String[] args) {
        flipByKTimesToFormLongestOnes(new int[]{1, 0, 0, 1, 1, 0, 1},1);
    }

}
