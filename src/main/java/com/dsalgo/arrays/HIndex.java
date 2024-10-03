package com.dsalgo.arrays;

import java.util.Arrays;

public class HIndex {

    public int hIndex(int[] citations) {

        //Sort the citations array
        Arrays.sort(citations);
        int n=citations.length;
        for(int i=0;i<citations.length;i++){
            //Finding the h value based on the number of papers remaining
            int h=n-i;

            //If current citations value is greater than or equal to current h value then return h
            if(citations[i]>=h){
                return h;
            }

        }
        return 0;
    }
}
