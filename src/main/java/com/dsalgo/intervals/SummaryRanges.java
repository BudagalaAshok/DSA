package com.dsalgo.intervals;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {

        List<String> ans = new ArrayList<>();
        int start = 0;
        int i = 0;
        int n = nums.length;

        while (i < n) {
            start=nums[i];

            while (i+1<n && nums[i+1]==nums[i]+1){
                i++;
            }

            if(start!=nums[i]){
                ans.add(start+"->"+nums[i]);
            }else{
                ans.add(String.valueOf(start));
            }
            i++;
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
    }
}
