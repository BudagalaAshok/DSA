package com.dsalgo.binarySearch;

public class MedianOfTwoSortedArrayUsingBS {

    public static float findMedian(int[] arr1, int[] arr2) {

        //taking the min length array always to perform this operation so checking this based on the condition we are interchanging the arrays
        if (arr2.length < arr1.length) {
            findMedian(arr2, arr1);
        }

        int l = 0;  //we can pick nothing from first array
        int h = arr1.length; //We can pick all elements from the first array
        while (l <= h) {
            int m1 = (l + h) / 2;
            //Calculating m2 based on m1 value why we are adding +1 here is to calculate median
            //Here why we are adding +1 some time total length becames even or odd, so work for these two cases adding +1
            int m2 = ((arr1.length + arr2.length + 1) / 2) - m1;

            //here l1 and l2 represents the left partition based on the m1 and m2
            //In the same way r1 and r2 represents the right partition based on m1 and m2
            //as per the table mentioned in the notes l1 is before the mid value
            int l1 = (m1 == 0) ? Integer.MIN_VALUE : arr1[m1-1]; // this is to handle edge cases of m1 is at starting position (Not taken any elements in the left partition)
            //as per the table r1 is the value after m1 so r1 is the m1+1
            int r1 = (m1 == arr1.length) ? Integer.MAX_VALUE : arr1[m1]; // this is to handle edge cases of m1 is at end of the array(taken all the elements in the right partition)

            //as per the table mentioned in the notes l2 is before the second mid value
            int l2 = (m2 == 0) ? Integer.MIN_VALUE : arr2[m2-1];
            //as per the table mentioned in the notes r2 is after the second mid value
            int r2 = (m2 == arr2.length) ? Integer.MAX_VALUE : arr2[m2];
            //If this condition satisfies that means it is a valid combination
            if (l1 <= r2 && l2 <= r1) {
                //If the total length of the array is even then we need to take the  l1,l2 max value and r1 and r2 min value
                if (arr1.length + arr2.length % 2 == 0) {
                    return (float) (Integer.max(l1, l2) + Integer.min(r1, r2)) / 2;
                } else {
                    //other-wise just return the max of l1 and l2
                    return (float) Integer.max(l1, l2);
                }
            }
            //If the above condition was not satisfied that means we need to increase  m1 value based on the l2 and r1
            else if (l2 > r1) {
                l = m1 + 1;
            }
            //If the above condition was not satisfied that means we need to decrease m1 value based on the r2 and l1
            else {
                h = m1 - 1;
            }

        }
        return 0.0f;
    }

    public static void main(String[] args) {
        //Define two arrays and calculate median
        int[] arr1 = {1, 3, 8, 17};
        int[] arr2 = {5, 6, 7, 19, 21, 25};
        System.out.println("Median was :"+findMedian(arr1, arr2));
    }
}
