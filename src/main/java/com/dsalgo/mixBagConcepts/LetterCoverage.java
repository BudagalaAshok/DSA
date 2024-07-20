package com.dsalgo.mixBagConcepts;

import java.util.Arrays;

public class LetterCoverage {

    public static boolean checkStringForAllTheLetters(String input) {
        int index = 0;
        boolean[] visited = new boolean[26];

        for (int id = 0; id < input.length(); id++) {
            if ('a' <= input.charAt(id) && input.charAt(id) <= 'z') {
                index = input.charAt(id) - 'a';
            } else if ('A' <= input.charAt(id) && input.charAt(id) <= 'Z') {
                index = input.charAt(id) - 'A';
            }
            visited[index] = true;
        }

        for (int id = 0; id < 26; id++) {
            if (!visited[id]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        /*int[] small=new int[26];
        int[] capital=new int[26];

        String s="askhtwsflkqwertYuioPasdfghjklZxcvbnm";
        for (int i = 0; i < s.length(); i++) {
            //Small case letters
            if(s.charAt(i)-97>=0) {
                small[s.charAt(i)-97]=1;
            }else{
                capital[s.charAt(i)-65]=1;
            }
        }

        long smallCount = Arrays.stream(small)
                .filter(b -> b==1) // Filter true values
                .count();
        long capitalCount = Arrays.stream(capital)
                .filter(b -> b==1) // Filter true values
                .count();

        if(smallCount+capitalCount==26){
            System.out.println("Yes");
        }

        System.out.println("Small letters Count:"+ smallCount);
        System.out.println("Capital Letters Count:"+ capitalCount);*/

        System.out.println(checkStringForAllTheLetters("askhtwsflkqwertYuioPasdfghjklZxcvbnm"));


    }

}
