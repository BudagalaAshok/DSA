package com.dsalgo.hashing;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> magazineMap = new HashMap<>();
        Map<Character, Integer> ransomNoteMap = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            magazineMap.put(ch, magazineMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()) {
            ransomNoteMap.put(ch, ransomNoteMap.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()) {
            if (magazineMap.containsKey(ch)) {
                ransomNoteMap.put(ch, ransomNoteMap.get(ch) - 1);
                magazineMap.put(ch, magazineMap.get(ch) - 1);

                if (ransomNoteMap.get(ch) == 0) {
                    ransomNoteMap.remove(ch);
                }

                if (magazineMap.get(ch) == 0) {
                    magazineMap.remove(ch);
                }
            } else {
                return false;
            }
        }

        return ransomNoteMap.size() == 0;


    }

    public static void main(String[] args) {

        RansomNote ransomNote = new RansomNote();
        System.out.println("O/P:" + ransomNote.canConstruct("aa", "ab"));
    }

}
