package com.dsalgo.strings;

import java.util.HashMap;
import java.util.Map;

public class BalancedString {


    public static int printBalancedString(String str){


        int count = 0;
        int balance = 0; // Variable to keep track of balance between 'L' and 'R'

        // Iterate through each character in the string
        for (char c : str.toCharArray()) {
            if (c == 'L') {
                balance++; // Increment balance if 'L' is encountered
            } else {
                balance--; // Decrement balance if 'R' is encountered
            }

            // If balance becomes zero, it means a balanced substring is found
            if (balance == 0) {
                count++; // Increment count of balanced substrings
            }
        }

        return count;


    }

    public static void compressString(String str){
        char currentCharacter=str.charAt(0);
        int count=1;
        for(int i=1;i<str.length();i++){

            if(currentCharacter==str.charAt(i)){
                count++;
            }else{
                System.out.print(currentCharacter +""+ count);
                currentCharacter=str.charAt(i);
                count=1;
            }

        }
        System.out.println(currentCharacter +""+ count);


    }

    public static void main(String[] args) {
        //System.out.println(printBalancedString("LRRLLLLRRLRR"));
        compressString("aaabbbbhhheaaAsssssss");
    }

}
