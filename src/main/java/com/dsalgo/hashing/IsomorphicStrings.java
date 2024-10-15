package com.dsalgo.hashing;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    //Optimal solution with out using extra space by checking character positions

    public boolean isIsomorphic(String s, String t) {
        int[] sMap = new int[256];
        int[] tMap = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if (sMap[sChar] != tMap[tChar]) {
                return false;
            }

            sMap[sChar] = i + 1;
            tMap[tChar] = i + 1;

        }

        return true;

    }

    //Using HashMaps
    public boolean isIsomorphicStrings(String s, String t) {

        Map<Character, Character> charMap = new HashMap<>();
        Map<Character, Character> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (charMap.containsKey(s.charAt(i))) {
                if (charMap.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                charMap.put(s.charAt(i), t.charAt(i));
            }
            if (tMap.containsKey(t.charAt(i))) {
                if (tMap.get(t.charAt(i)) != s.charAt(i)) {
                    return false;
                }
            } else {
                tMap.put(t.charAt(i), s.charAt(i));
            }

        }
        return true;

    }

}
