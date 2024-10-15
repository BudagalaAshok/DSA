package com.dsalgo.twoPointers;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters
 * without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int p1=0;
        int p2=0;

        while(p2<t.length()){

            if(p1<s.length() && s.charAt(p1)==t.charAt(p2)){
                p1++;
            }
            p2++;
        }
        return p1==s.length();

    }
}
