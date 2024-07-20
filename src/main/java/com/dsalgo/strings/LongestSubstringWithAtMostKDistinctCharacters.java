package com.dsalgo.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {

    public static int findLongestSubstringWithDistinctChars(String str, int k) {

        int left = 0;
        int right = 0;
        int maxLength = 0;
        Map<Character,Integer> characterIntegerMap=new HashMap<>();
        while (right < str.length()) {
            characterIntegerMap.put(str.charAt(right),characterIntegerMap.getOrDefault(str.charAt(right),0)+1);
            //That means we have more than 3 distinct characters
            if(characterIntegerMap.size()>k){
                //if we have more than that then we can decrement the count of that particular character and move left pointer by 1 position
                //If the char count is zero in the hashmap then we can remove that char from hashmap
                characterIntegerMap.put(str.charAt(right),str.charAt(right)-1);
                if(characterIntegerMap.get(str.charAt(right))==0){
                    characterIntegerMap.remove(str.charAt(right));
                }
                left++;
            }
            //If distinct characters count is less than k then we can find the maxLength and update
            if(characterIntegerMap.size()<=k){
                maxLength=Math.max(maxLength,right-left+1);
            }
            right++;
        }
        return maxLength;


    }

    public static void main(String[] args) {
        System.out.println(findLongestSubstringWithDistinctChars("aaabbbbbccccd",2));
    }

}
