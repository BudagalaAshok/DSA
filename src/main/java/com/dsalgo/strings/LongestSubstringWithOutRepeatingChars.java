package com.dsalgo.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithOutRepeatingChars {

    public static int printSubstrings(String str) {

        if(str.isEmpty()||str==null){
            return 0;
        }

        // finding the length of the string
        int n = str.length();
        int maxLength=Integer.MIN_VALUE;

        // outermost for loop
        // this is for the selection
        // of starting point
        for (int i = 0; i < n; i++) {

            // 2nd for loop is for selection
            // of ending point
            Map<Character, Integer> charMap = new HashMap<>();
            for (int j = i; j < n; j++) {
                StringBuilder sb = new StringBuilder();
                // 3rd loop is for printing from
                // starting point to ending point
                charMap.put(str.charAt(j), charMap.getOrDefault(str.charAt(j), 0) + 1);
                //System.out.print(str.charAt(k));
                boolean condition = charMap.entrySet().stream().allMatch(characterIntegerEntry -> characterIntegerEntry.getValue() == 1);
                if (condition) {
                    maxLength = Math.max(charMap.size(), maxLength);
                }

            }
        }

        System.out.println("Max Length was :"+maxLength);
        return maxLength;
    }

    public static int printSubStringWithOutCharacters(String str){

        Map<Character,Integer> characterIntegerMap=new HashMap<>();
        int left=0;
        int right=0;
        int maxLength=0;
        int length=0;
        while(right<str.length()){
            if(characterIntegerMap.containsKey(str.charAt(right))){
                if(characterIntegerMap.get(str.charAt(right))>=left) {
                    left = characterIntegerMap.get(str.charAt(right)) + 1;
                }
            }
            length=right-left+1;
            maxLength=Math.max(length,maxLength);
            characterIntegerMap.put(str.charAt(right),right);
            right++;

        }
        return maxLength;

    }

    public static void main(String[] args) {
        System.out.println("max length using O(n) "+printSubStringWithOutCharacters("abcabcbb"));

    }
}
