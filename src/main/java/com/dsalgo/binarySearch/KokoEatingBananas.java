package com.dsalgo.binarySearch;

public class KokoEatingBananas {


    public static int minEatingSpeed(int[] piles, int hours) {

        //low was the min number of piles
        //High was the total no of bananas
        int low = 1;//At least one banana we can per hour so that is minimum
        int high = Integer.MIN_VALUE;//High was max value of the pile

        //Instead of another variable we can always return the low value also because from that low value we have everything is possible
        //At end low ends the possible solution, high ends at the not possible solution

        //0(n)*log2(max of element) ->
        for (int i = 0; i < piles.length; i++) {

            if (high < piles[i]) {
                high = piles[i];
            }

        }

        int res = -1;

        while (low <= high) {

            int mid = (low + high) / 2;
            int totalHours= getTotalHours(piles,mid);
            if (totalHours>0 && totalHours<=hours) {
                res = mid;
                high = mid - 1;
            }else{
                low=mid+1;
            }

        }
        return res;

    }

    private static int getTotalHours(int[] piles, int mid) {

        int totalHour = 0;
        for (int i = 0; i < piles.length; i++) {
            totalHour+=(int)Math.ceil((double)(piles[i])/(double) (mid));

        }
        return totalHour;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{805306368,805306368,805306368},1000000000));
    }
}
