package com.dsalgo.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreakSolution(String str, List<String> wordDict) {

        boolean[] dp = new boolean[str.length() + 1];
        dp[str.length()] = true;
        for (int i = str.length() - 1; i >= 0; i--) {
            for(String w:wordDict){
                if((i + w.length()) <= str.length() && str.startsWith(w, i)){
                    dp[i] = dp[i + w.length()];
                }
                if(dp[i]){
                    break;
                }
            }
        }
        return dp[0];

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


    public static void main(String[] args) {
        WordBreak wordBreak=new WordBreak();
        List<String> wordDict=new ArrayList<>();
        wordDict.add("Leet");
        wordDict.add("Neet");
        wordDict.add("Code");
       //System.out.println(wordBreak.wordBreakSolution("LeetsCode",wordDict));
       System.out.println("Using Bottom Up :"+wordBreak.wordBreakUsingBottomUp("Code",wordDict));
    }
}
