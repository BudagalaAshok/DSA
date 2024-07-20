package com.dsalgo.arrays;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {


    public static int[][] mergeInterval(int[][] intervals){

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int idx=0;
        int[] current=intervals[0];
        for (int i = 0; i < intervals.length; i++) {
            if(isOverLappingInterval(current,intervals[i])){
                intervals[idx]=new int[]{Math.min(current[0],intervals[i][0]),Math.max(current[1],intervals[i][1])};
                current=intervals[idx];
            }
            else{
                intervals[++idx]=intervals[i];
                current=intervals[idx];
            }
        }

        int [][] res=new int[idx+1][2];
        System.arraycopy(intervals,0,res,0,idx+1);
        return res;


    }

    /*
      First sort the intervals
      Here the intitution is iterate each interval and check if is overlapped or not. if it is overlapped and then merge. If it is not overlapped then break and move to the next interval
      while moving to the next interval we check if that interval is already fall under the current interval we store then skip
      //TC: sorting(nlogn)+2*n(inside we are not going up to now if it is already merged then we are skipping few iterations
     */

    public static void mergeOverLappingIntervals(int[][] intervals){

        //Sort the intervals
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        List<List<Integer>> ans= Lists.newArrayList();
        for (int i=0;i<intervals.length;i++){

            int start=intervals[i][0];
            int end=intervals[i][1];
            //{1,6},{2,4}
            //Check if the interval is already merged or present inside the previous interval then skip
            if(!ans.isEmpty() && end<=ans.get(ans.size()-1).get(1)){
                continue;
            }

            //Else we need to traverse and find the overlapping intervals and merge
            //starting from next interval and check
            //{1,3},{2,4}
            for (int j = i+1; j < intervals.length; j++) {
                //How can we check
                if(end>=intervals[j][0]){
                    end=Math.max(end,intervals[j][1]);
                }else{
                    //No need to check it is not overlapping
                    break;
                }

            }
            ans.add(Lists.newArrayList(start,end));

        }
        printIntervals(ans);

    }

    private static void printIntervals(List<List<Integer>> ans) {
        for(List<Integer> eachInterval: ans){
            eachInterval.forEach(integer -> System.out.print(integer+" ,"));
            System.out.println();
        }
    }

    public static void mergeIntervalWithOptimizedApproach(int[][] intervals){

        //sort the array
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<List<Integer>> ans=new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {

            //first check if the ans is empty or if it has element check we need to form any new interval
            if(ans.isEmpty() || intervals[i][0]>ans.get(ans.size()-1).get(1)){
                ans.add(Lists.newArrayList(intervals[i][0],intervals[i][1]));
            }else{
                //Merge the overlapping interval
                int end=intervals[i][1];
                if(end>=ans.get(ans.size()-1).get(0)){
                    end=Math.max(end,ans.get(ans.size()-1).get(1));
                    ans.get(ans.size()-1).set(1,end);
                }
            }

        }
        printIntervals(ans);


    }

    private static boolean isOverLappingInterval(int[] current, int[] interval) {
        return Math.min(current[1],interval[1])-Math.max(current[0],interval[0])>=0;
    }

    public static void main(String[] args) {
        int[][] intervals=  {{1,3},{2,6},{8,10},{15,18}};
        mergeOverLappingIntervals(intervals);
        mergeIntervalWithOptimizedApproach(intervals);
        System.out.println(Arrays.deepToString(mergeInterval(intervals)));
    }

}
