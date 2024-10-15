package com.dsalgo.twoPointers;

public class ValidPalindrome {


    //Brute force approach is using StringBuilder iterate string from backwards or front
    //If we are iterating from front then check if the character is capital or small , incase if it is capital find the respective small character and append
    //If it is digit skip or alphanumeric.
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

    //Second one is using two pointers
    public boolean isPalindromeUsingTwoPointers(String validString){

        int start=0;
        int end=validString.length()-1;
        while(start<end){
            //Check if it is not letter or digit, then increment left pointer
            while (start<end && !Character.isLetterOrDigit(validString.charAt(start))){
                start++;
            }
            //Check if it is not letter or digit, then decrement right pointer from end
            while(start<end && !Character.isLetterOrDigit(validString.charAt(end))){
                end--;
            }

            if(Character.toLowerCase(validString.charAt(start))!=Character.toLowerCase(validString.charAt(end))){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindromeUsingTwoPointers("A man, a plan, a canal: Panama"));
    }

}
