package com.dsalgo.arrays;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) {
            return "";
        }

        //Take first string as reference string or base string
        String prefix = strs[0];

        //Now starts with the remaining strings and compare
        for (int i = 1; i < strs.length; i++) {

            //Checking the prefix exists in the current string if it exists shrink the size of prefix
            while (strs[i].indexOf(prefix) != 0) {
                //Shrink the prefix by removing the character
                prefix = prefix.substring(0, prefix.length() - 1);
                //If any one of the case prefix return empty string then return empty string
                if (prefix.isEmpty()) {
                    return "";
                }
            }

        }

        return prefix;

    }
}
