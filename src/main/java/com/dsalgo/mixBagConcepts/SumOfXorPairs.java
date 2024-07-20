package com.dsalgo.mixBagConcepts;

public class SumOfXorPairs {

    /**
     * Let say elements are a,b,c
     * (a^a)+(a^b)+(a^c)
     * (b^a)+(b^b)+(b^c)
     * (c^a)+(c^b)+(c^c)
     * Here all the diagonal elements got cancelled and we can see here upper right diagonal and lower left diagonal elements are same
     *
     * @param arr
     */
    public static void findSumXorOfPairs(int[] arr) {

        long ans = 0;
        for (int i = 0; i <= 30; i++) {

            long count = 0;
            for (int k : arr) {

                if (checkBit(k, i) != 0) {
                    count++;
                }

            }
            //Here we are finding count for that bit position how many 1 are there that is count
            //after that from that array length we are subtracting no of 1's count give us zeros. Then multiply those paris and in that position we are calculating 2 to power of i

            ans = ans + (count * (arr.length - count) * (1 << i));

        }

        System.out.println(ans * 2);


    }

    public static int checkBit(int number, int bit) {

        return (number >> bit) & 1;
    }

    public static void main(String[] args) {
        findSumXorOfPairs(new int[]{5, 12, 8});
    }

}
