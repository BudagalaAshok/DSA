package com.dsalgo.twoPointers;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {

        if (s.isEmpty()) {
            return true;
        }

        StringBuilder finalString = new StringBuilder();
        for (char ch : s.toCharArray()) {
            //Check for if it is an capital letter
            if (ch >= 65 && ch <= 90) {
                char replacedChar = (char) (ch + 32);
                finalString.append(replacedChar);
                System.out.println(ch + 32 + " " + replacedChar);
            }
            //Check for number
            else if (ch >= 97 && ch <= 125) {
                finalString.append(ch);
            }

        }
        String reverseString = String.valueOf(finalString.reverse());
        System.out.println("Reverse String : "+reverseString);
        System.out.println("Final Converted String:" + finalString.toString());
        return reverseString.equals(finalString.toString());

    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("race a car"));
    }

}
