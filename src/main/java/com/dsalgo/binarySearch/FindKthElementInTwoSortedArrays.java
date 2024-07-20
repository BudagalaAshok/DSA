package com.dsalgo.binarySearch;

public class FindKthElementInTwoSortedArrays {

    public static float findKthElementUnderSortedArrays(int[] arr1, int[] arr2,int n1,int n2, int k) {

        //taking the min length array always to perform this operation so checking this based on the condition we are interchanging the arrays
        if (arr2.length < arr1.length) {
            findKthElementUnderSortedArrays(arr2, arr1,n1,n2,k);
        }

        int l = Math.max(0,k-n2);  //we can pick up zero from array1 or k-n2
        //Let say k value is 7 and n1(6)+n2(5) is 11, in that case let say we pick 7 elements from left and 4 elements from right
        //In above example let say in left we pick all elements from n2(arr2) still we need 2 elements that should be pick up from n1(arr1)
        //For example if k is 2 and array1 have 6 elements we can't pick 6 elements to find the kth element
        int h = Math.min(k,n1);// Here we can pick min of k elements from array 1
        while (l <= h) {
            int m1 = (l + h) / 2;
            //Calculating m2 based on m1 value why we are adding +1 here is to calculate median
            //Here why we are adding +1 some time total length becames even or odd, so work for these two cases adding +1
            int m2 = ((arr1.length + arr2.length + 1) / 2) - m1;

            //here l1 and l2 represents the left partition based on the m1 and m2
            //In the same way r1 and r2 represents the right partition based on m1 and m2
            //as per the table mentioned in the notes l1 is before the mid value
            int l1 = (m1 == 0) ? Integer.MIN_VALUE : arr1[m1 - 1]; // this is to handle edge cases of m1 is at starting position (Not taken any elements in the left partition)
            //as per the table r1 is the value after m1 so r1 is the m1+1
            int r1 = (m1 == arr1.length) ? Integer.MAX_VALUE : arr1[m1]; // this is to handle edge cases of m1 is at end of the array(taken all the elements in the right partition)

            //as per the table mentioned in the notes l2 is before the second mid value
            int l2 = (m2 == 0) ? Integer.MIN_VALUE : arr2[m2 - 1];
            //as per the table mentioned in the notes r2 is after the second mid value
            int r2 = (m2 == arr2.length) ? Integer.MAX_VALUE : arr2[m2];
            //If this condition satisfies that means it is a valid combination
            if (l1 <= r2 && l2 <= r1) {
                //If the total length of the array is even then we need to take the  l1,l2 max value and r1 and r2 min value
                return (float) Integer.max(l1, l2);
            }
            //If the above condition was not satisfied that means we need to increase  m1 value based on the l2 and r1
            //Moving m1 to right
            else if (l2 > r1) {
                l = m1 + 1;
            }
            //If the above condition was not satisfied that means we need to decrease m1 value based on the r2 and l1
            //Moving m1 to left
            else {
                h = m1 - 1;
            }

        }
        return 0.0f;
    }

    public static void main(String[] args) {

         int[] arr1=new int[]{2,3,45};
         int[] arr2=new int[]{4,6,7,8};
        System.out.println(findKthElementUnderSortedArrays(arr1,arr2,3,4,4));

    }

}
