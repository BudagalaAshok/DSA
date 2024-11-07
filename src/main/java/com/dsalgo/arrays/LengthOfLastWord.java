package com.dsalgo.arrays;

import java.util.Arrays;

public class LengthOfLastWord {

    public int lengthOfLastWordInAnSentence(String sentence) {
        //first trim the sentence
        sentence = sentence.trim();
        System.out.print(sentence);
        boolean isWord = false;
        int length = sentence.length() - 1;
        while (!Character.isLetter(sentence.charAt(length))) {
            length--;
        }

        int lastWordLength = 0;
        for (int i = length; i >= 0; i--) {

            if (Character.isLetter(sentence.charAt(i))) {
                lastWordLength++;
                isWord = true;
            } else if (isWord) {
                break;
            }

        }
        return lastWordLength;
    }

    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        System.out.println("Length was :" + lengthOfLastWord.lengthOfLastWordInAnSentence(" Hello   This is  a  world   "));
    }

}
