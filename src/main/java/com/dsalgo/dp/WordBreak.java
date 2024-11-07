package com.dsalgo.dp;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {


    //Time complexity was O(n^2)
    public boolean wordBreakUsingDP(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            // Check each substring s[j:i]
            for (int j = 0; j < i; j++) {
                // If dp[j] is true and s[j:i] is in the dictionary, mark dp[i] as true
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }

        }
        return dp[n];
    }

    public boolean wordBreakUsingBottomUp(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict); // Convert list to set for O(1) lookups
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Base case: empty string

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // No need to check further if we found a valid split
                }
            }
        }

        return dp[s.length()];
    }

    public boolean wordBreakUsingRecursion(String s, List<String> wordDict) {

        return wordBreakHelper(s, wordDict);

    }

    /**
     * Recursively checking substring in wordDict if at finally the given string is empty then return true
     * Time Complexity is exponential here O(2^n)
     *
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreakHelper(String s, List<String> wordDict) {

        //Base case
        if (s.isEmpty()) {
            return true;
        }

        for (int i = 0; i < s.length(); i++) {
            String subString = s.substring(0, i);
            if (wordDict.contains(subString)) {
                if (wordBreakHelper(subString, wordDict)) {
                    return true;
                }
            }


        }
        return false;
    }


    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("Leet");
        wordDict.add("Neet");
        wordDict.add("Code");
        //System.out.println(wordBreak.wordBreakSolution("LeetsCode",wordDict));
        //System.out.println("Using Bottom Up :"+wordBreak.wordBreakUsingBottomUp("Code",wordDict));
        System.out.println(wordBreak.wordBreakUsingDP("applepenapple", Lists.newArrayList("apple", "pen")));
    }
}
