package com.dsalgo.subSequence;

public class LongestPalindromeSubString {

    public static void printSubstrings(String str) {

        // finding the length of the string
        int count = 0;
        int n = str.length();

        // outermost for loop
        // this is for the selection
        // of starting point
        for (int i = 0; i < n; i++) {

            // 2nd for loop is for selection
            // of ending point
            for (int j = i; j < n; j++) {

                // 3rd loop is for printing from
                // starting point to ending point
                for (int k = i; k <= j; k++) {
                    System.out.print(str.charAt(k));
                }

                // changing the line after printing
                // from starting point to ending point
                System.out.println();
            }
        }
    }

    public static String longestPalindromicSubstring(String str) {
        //We need to find both even and odd palindromic substring and find out which one is one maximum out of those

        //If string length < 2 then directly return
        if (str.length() < 2) {
            return str;
        }

        int ans = 0;
        int low = 0;
        int high = 0;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            //Even palindrome
            low = i;
            high = i;
            //Putting the pointers at the same position because character itself is a substring and it self a palindrome
            while (low != -1 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > ans) {
                    ans = high - low + 1;
                    result = str.substring(low, high + 1);
                }
                low--;
                high++;
            }

            //Odd palindrome length
            //cover cases like racecar -> this is also palindrome for this type of cases we need to compare with the same letter itself
            low = i;
            high = i + 1;

            while (low != -1 && high < str.length() && str.charAt(low) == str.charAt(high)) {
                if (high - low + 1 > ans) {
                    ans = high - low + 1;
                    result = str.substring(low, high + 1);
                }
                low--;
                high++;
            }

        }
        return result;


    }

    public static void main(String[] args) {
        //printSubstrings("abcd");
        //0(n to power of 2) and brute force is 0(n to power of 3)
       printSubstrings("babad");
        System.out.println("Longest Palindromic String: "+longestPalindromicSubstring("babad"));

    }


}
