package com.dsalgo.recursion;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

public class ReverseString {

    //abc --> cba

    //one way using stack
    public void revereStringUsingStack(String input){
        Stack<Character> stack=new Stack<>();
        for (char ch:input.toCharArray()){
            stack.push(ch);
        }
        StringBuilder stringBuilder=new StringBuilder();
        while (!stack.isEmpty()){
            stringBuilder.append(stack.pop());
        }
        System.out.println(stringBuilder.toString());

    }


    //Using recursion
    public void reverseRecursion(String input, List<Character> characterList, int idx){

        if(idx==-1){
            System.out.println(characterList.toString());
            return;
        }
        characterList.add(input.charAt(idx));
        reverseRecursion(input,characterList,idx-1);
    }

    //Another way of doing recursion for string reverse
    public static String reverse(String str) {
        // Base case: if the string is empty or has one character, return it as is
        if (str == null || str.length() <= 1) {
            return str;
        }

        // Recursive case: reverse the substring starting from the second character
        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        ReverseString reverseString=new ReverseString();
        String str="Ashok";
        reverseString.revereStringUsingStack(str);
        reverseString.reverseRecursion(str, Lists.newArrayList(),str.length()-1);
    }




}
