package com.dsalgo.mixBagConcepts;

import java.io.*;
import java.util.*;

public class BalancedParentheses {
    public static void balancedParentheses(char[] charArray, int n, int leftCount, int rightCount, int index) {

        if (index == n) {
            for(char ch:charArray){
                System.out.print(ch);
            }
            System.out.println();
        }
        if (leftCount < n / 2) {
            charArray[index] = '{';
            balancedParentheses(charArray, n, leftCount + 1, rightCount, index + 1);
        }

        if (rightCount < leftCount) {
            charArray[index] = '}';
            balancedParentheses(charArray, n, leftCount, rightCount + 1, index + 1);
        }

    }

    public static void generateBalancedParentheses(int n, int openCount, int closeCount, String current, List<String> result) {
        // Base case: If current string length is equal to 2*n, add to result if it's balanced
        if (current.length() == 2 * n) {
            if (openCount == closeCount) {
                result.add(current);
            }
            return;
        }

        // Add an opening parenthesis if the count of opening parentheses is less than n/2
        if (openCount < n ) {
            generateBalancedParentheses(n, openCount + 1, closeCount, current + "(", result);
        }

        // Add a closing parenthesis if the count of closing parentheses is less than the count of opening parentheses
        if (closeCount < openCount) {
            generateBalancedParentheses(n, openCount, closeCount + 1, current + ")", result);
        }
    }

    public static List<String> generateBalancedParentheses(int n) {
        List<String> result = new ArrayList<>();
        generateBalancedParentheses(n, 0, 0, "", result);
        return result;
    }

        public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
            System.out.println(generateBalancedParentheses(4).toString());
       /* Scanner sc = new Scanner(System.in);
        int totalTestCases = sc.nextInt();
        for (int i = 0; i < totalTestCases; i++) {

            int number = sc.nextInt();
            char[] charArray = new char[2 * number];
            balancedParentheses(charArray, 2 * number, 0, 0, 0);

        }*/
    }
}
