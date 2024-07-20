package com.dsalgo.mixBagConcepts;

public class CalculateAtoPowerOfN {


    //Complexity log2 base n
    public static int aToPowerOfN(int a, int n) {
        if (n == 0) {
            return 1;
        }
        int x = aToPowerOfN(a, n / 2);
        if (n % 2 == 0) {
            return x * x;
        } else {
            return (x * x) * a;
        }

    }

    //Time complexity of O(n)
    public static int aTON(int a, int n) {
        if (n == 0) {
            return 1;
        }
        return a * aTON(a, n - 1);

    }


    public static void main(String[] args) {
        System.out.println(aToPowerOfN(2, 2));
    }

}
