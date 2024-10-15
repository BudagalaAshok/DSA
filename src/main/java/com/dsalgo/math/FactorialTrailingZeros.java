package com.dsalgo.math;

public class FactorialTrailingZeros {

    public int trailingZeroes(int n) {
        //If the number is greater than or equal to 5 then we can divide with 5 and take the quotient
        // we need to do until and unless n<=5 and then return the sum of quotient
        int count = 0;
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
