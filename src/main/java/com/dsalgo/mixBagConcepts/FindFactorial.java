package com.dsalgo.mixBagConcepts;

import java.math.BigInteger;

public class FindFactorial {

    public static long findFactorial(int number){
        long result=1;
        int modulus=1000000007;
        if(number==1){
            return 1;
        }else {
            result= number * findFactorial(number - 1);
        }
        return result%modulus;

    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(1000));
    }
}
