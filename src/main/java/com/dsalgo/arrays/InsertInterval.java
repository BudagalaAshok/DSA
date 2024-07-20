package com.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static List<int[]> insertInterval(int[][] intervals,int[] newInterval){

        int n=intervals.length,i=0;
        List<int[]> res=new ArrayList<>();

        //Here assuming already array is sorted

        //Case 1: No Overlapping before merging intervals
        while(i<n && intervals[i][1]<newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        //Case 2: Overlapping and merging intervals
        while(i<n && newInterval[1]>=intervals[i][0]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[0],intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        //Case 3: No overlapping after merging new interval
        while(i<n){
            res.add(intervals[i]);
            i++;
        }
       return res;
    }

    public static void main(String[] args) {
        List<int[]> ints = insertInterval(new int[][]{{1, 3}, {6, 9}}, new int[]{4, 5});
        ints.forEach(ints1 -> {
            System.out.println(Arrays.toString(ints1));
        });

    }

}
