package com.dsalgo.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubString {

    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int matched = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char right = s.charAt(endWindow);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()) {
                if (minLen > endWindow - start + 1) {
                    minLen = endWindow - start + 1;
                    subStr = start;
                }
                char deleted = s.charAt(start++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) {
                        matched--;
                    }
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }


    //Brute Force approach
    //Find all substrings and for each substring find the pattern is available or not

    public int findMinWindowSubstringLength(String s, String pattern) {

        int n = s.length();
        int minLength = Integer.MAX_VALUE;
        String smallestSubString = "";

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                String subString = s.substring(i, j + 1);

                if (isValidSubString(subString, pattern)) {
                    if (subString.length() < minLength) {
                        minLength = subString.length();
                        smallestSubString = subString;
                    }
                }

            }

        }
        System.out.println("Min Sub string was :" + smallestSubString);
        return minLength;

    }

    private boolean isValidSubString(String subString, String pattern) {
        //Contains all kinds of characters,numbers,and special characters
        int[] ch = new int[256];

        //First first the pattern characters
        for (char character : pattern.toCharArray()) {
            ch[character]++;
        }

        //Now find the substring characters and reduce the count
        for (char originalChar : subString.toCharArray()) {
            if (ch[originalChar] > 0) {
                ch[originalChar]--;
            }
        }

        //Now find all characters are removed or not
        for (int i = 0; i < 256; i++) {
            if (ch[i] > 0) {
                return false;
            }

        }

        return true;


    }


    //Using slidingwindow technique and Hashing
    public String findMinWindowSubString(String s, String t) {


        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int length = s.length();
        int minLeft = 0;
        char ch;

        //Pattern window Map
        Map<Character, Integer> patternWindowMap = new HashMap<>();
        Map<Character, Integer> currentWindowMap = new HashMap<>();
        for (char eachChar : t.toCharArray()) {
            patternWindowMap.put(eachChar, patternWindowMap.getOrDefault(eachChar, 0) + 1);
        }
        //Count unique characters
        int required = patternWindowMap.size();
        int formed = 0;

        //Now sliding window
        while (right < length) {
            ch = s.charAt(right);
            //put in to the current Window map
            currentWindowMap.put(ch, currentWindowMap.getOrDefault(ch, 0) + 1);
            //when we found a match then we need to increment the count of formed
            if (patternWindowMap.containsKey(ch) && Objects.equals(patternWindowMap.get(ch), currentWindowMap.get(ch))) {
                formed++;
            }

            //when we found a match then we need to shrink the window and find the min length
            while (left <= right && required == formed) {

                ch = s.charAt(left);

                //we need to store the minWindowLength
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                }

                currentWindowMap.put(ch, currentWindowMap.get(ch) - 1);
                if (patternWindowMap.containsKey(ch) && currentWindowMap.get(ch) < patternWindowMap.get(ch)) {
                    formed--;
                }

                left++;


            }

            right++;

        }

        return minLeft == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLength);


    }


    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

}
