package com.dsalgo.mixBagConcepts;

public class XOROfSumPairs {

    //When we do xor of sum of pairs let say elements are a,b,c
    /*(a+a)^(a+b)^(a+c)
      (b+a)^(b+b)^(b+c)
      (c+a)^(c+b)^(c+c)
     */
    //above all elements got cancelled expect (a+a)(b+b)(c+c) because of that this was the code looks like
    public static void findSumOfXorPairs(int[] arr) {

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = ans ^(2 * arr[i]);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        findSumOfXorPairs(new int[]{4, 10, 54, 11, 8});
    }

}
