package com.dsalgo.hashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> hashSet = new HashSet<>();
        for (int eachNum : nums) {
            hashSet.add(eachNum);
        }

        int longestStreak = 0;

        for (int eachNumber : hashSet) {

            //Checking if it is first number or not if it is first number check for sequence
            if (!hashSet.contains(eachNumber - 1)) {
                int currentNum = eachNumber;
                int currentStreak = 1;

                //Check for sequence and increment the sequence length
                while (hashSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                longestStreak = Math.max(longestStreak, currentStreak);

            }

        }
        return longestStreak;


    }

    public static void main(String[] args) {
        LongestConsecutiveSequence consecutiveSequence = new LongestConsecutiveSequence();
        System.out.println("Longest sequence Length is :" + consecutiveSequence.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

}
