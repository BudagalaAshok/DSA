package com.dsalgo.slidingWindow;

import java.util.*;

public class SubstringWithConcatenationOfAllStrings {


    public List<Integer> findIndexesOfAllSubstrings(String inputString, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (inputString == null || words.length == 0 || words == null) {
            return ans;
        }

        int totalWords = words.length;
        int wordLength = words[0].length();
        int totalWordsLength = wordLength * totalWords;

        //Storing the frequencies of eachword in a map
        Map<String, Integer> wordFreqMap = new HashMap<>();
        for (String eachWord : words) {
            wordFreqMap.put(eachWord, wordFreqMap.getOrDefault(eachWord, 0) + 1);
        }

        //Now going by character by character to find the substring exists in the given input string
        //Iterating the characters up to total input string length - totalwords length because in the next step we are adding the totalwords length
        for (int i = 0; i < inputString.length() - totalWordsLength; i++) {

            //Taking the substring based in the totalwords length
            String currentSubString = inputString.substring(i, i + totalWordsLength);
            if (isValid(currentSubString, wordFreqMap, wordLength)) {
                ans.add(i);
            }

        }

        return ans;


    }

    private boolean isValid(String currentSubString, Map<String, Integer> wordFreqMap, int wordLength) {
        Map<String, Integer> currentWordMap = new HashMap<>();
        //Iterating the substring by incrementing the each word length and take the substring by each word length and checking if it is present in our freq map or not
        for (int j = 0; j < currentSubString.length(); j += wordLength) {
            String word = currentSubString.substring(j, j + wordLength);
            //If it is not present then return false
            if (!wordFreqMap.containsKey(word)) {
                return false;
            }
            //Inserting the words into another map
            currentWordMap.put(word, currentWordMap.getOrDefault(word, 0) + 1);
            //If the current word frequencey is greater than actual frequencey map then it is false
            if (currentWordMap.get(word) > wordFreqMap.get(word)) {
                return false;
            }

        }
        return true;
    }


    public static void main(String[] args) {

        SubstringWithConcatenationOfAllStrings concatenationOfAllStrings = new SubstringWithConcatenationOfAllStrings();
        System.out.println("The indexes are :"+ concatenationOfAllStrings.findIndexesOfAllSubstrings("barfoothefoobarman", new String[]{"foo", "bar"}));
    }

}
