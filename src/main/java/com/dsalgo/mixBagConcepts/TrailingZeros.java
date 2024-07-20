package com.dsalgo.mixBagConcepts;

public class TrailingZeros {

        public static void main(String[] args) {
            int A = 5;
            if (A < 0) // Negative Number Edge Case
                System.out.println("-1");

            // Initialize result
            int count = 0;

            // Keep dividing n by powers
            // of 5 and update count
            for (int i = 5; A / i >= 1; i *= 5)
                count += A / i;

            System.out.println(count);
        }

}
