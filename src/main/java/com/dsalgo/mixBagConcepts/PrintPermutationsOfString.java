package com.dsalgo.mixBagConcepts;

public class PrintPermutationsOfString {

    public static void printCombinations(char[] s1, int i, int n, char[] s2, int j, int m, char[] s3, int k) {

        //Base condition
        if (i == n) {

            for (int l = 0; l < k; l++) {
                System.out.print(s3[i]);
            }

        }
        if (j == m) {
            for (int o = j; o < m; o++) {
                System.out.println(s3[o]);
            }
        }

        if (s1[i] < s2[j]) {
            s3[k] = s1[i];
            printCombinations(s1, i + 1, n, s2, j, m, s3, k + 1);
            s3[k] = s2[j];
            printCombinations(s1, i, n, s2, j + 1, m, s3, k + 1);

        } else {
            s3[k] = s2[j];
            printCombinations(s1, i, n, s2, j + 1, m, s3, k + 1);
            s3[k] = s1[i];
            printCombinations(s1, i + 1, n, s2, j, m, s3, k + 1);
        }

    }

    /*
    O(N * N!) Note that there are N! permutations and it requires O(N) time to print a permutation.
    Auxiliary Space: O(R – L)
     */
    public static void printPermutations(char[] chars, int fi) {

        if (fi == chars.length - 1) {
            System.out.println(chars);
            return;
        }

        for (int i = fi; i < chars.length; i++) {
            swap(chars, i, fi);
            printPermutations(chars, fi + 1);
            swap(chars, i, fi);
        }

    }

    private static void swap(char[] chars, int i, int fi) {

        char temp = chars[i];
        chars[i] = chars[fi];
        chars[fi] = temp;

    }

    public static void main(String[] args) {

        char[] s1 = new char[]{'a', 'b', 'c'};
        char[] s2 = new char[]{'c', 'd'};
        int n = s1.length + s2.length;
        char[] s3 = new char[s1.length + s2.length];

        //printCombinations(s1, 0, n, s2, 0, 0, s3, 0);

        printPermutations(s1, 0);


    }

}
