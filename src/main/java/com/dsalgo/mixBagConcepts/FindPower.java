package com.dsalgo.mixBagConcepts;

import static java.lang.Math.log;

public class FindPower {
    public static long findPow(long a, long n) {

        long ans = 1;
        int modulus=1000000007;
        long x = a;
        while (n != 0) {
            int flag = (int)n & 1;
            if (flag == 1) {
                ans = (ans * x)%modulus;

            }
            x = (x* x)%modulus;
            n = n >> 1;
        }
        return ans;

    }

    public static int findPowerUsingBit(int a, int n) {
        int ans=1;
        int x=a;
        for (int i = 0; i < log(n); i++) {

            if(checkBit(n,i)==1){
                ans=ans*x;
            }
            x*=x;
        }
        return ans;
    }

    public static int checkBit(int num, int i) {

        return (num >> i) & 1;

    }

    public static void main(String[] args) {
        System.out.println("Power of 3 to 3 -->" + findPow(1000000, 1000000000));

        //System.out.println("Power of 3 to 3 using bits -->" + findPowerUsingBit(3, 5));
    }

}
