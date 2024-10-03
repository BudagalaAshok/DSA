package com.dsalgo.stacks;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class ValidParenthesis {

    //This one we can achieve using stack and hash map also

    public static boolean isValidParenthesis(String str) {

        if (str.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {

            if (stack.isEmpty() && (str.charAt(i) == ')' || str.charAt(i) == ']' || str.charAt(i) == '}')) {
                return false;
            }
            switch (str.charAt(i)) {

                case ')':
                    if (stack.peek() == '(') {
                        stack.pop();
                    }
                    break;
                case ']':
                    if (stack.peek() == '[') {
                        stack.pop();
                    }
                    break;
                case '}':
                    if (stack.peek() == '{') {
                        stack.pop();
                    }
                    break;
                default:
                    stack.push(str.charAt(i));
            }


        }

        return stack.isEmpty();
    }

    public static boolean isValidParenthesisUsingHashMap(String expression) {

        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put('}', '{');
        hashMap.put(']', '[');

        for (int i = 0; i < expression.length(); i++) {
            if (hashMap.containsKey(expression.charAt(i))) {
                if (!stack.isEmpty() && hashMap.get(expression.charAt(i)).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }

            } else {
                stack.push(expression.charAt(i));
            }

        }
        return stack.isEmpty();
    }

    public static void test() {
        String s = "/home/ashok//./master";
        String[] arr = s.split("/");
        Stack<String> stack = new Stack<>();
        for (String item : arr) {
            if (!item.isEmpty() && !item.equals(".")) {
                stack.push(item);
            }else if(item.equals("..")){
                stack.pop();
            }

        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        System.out.println("Only Stack:" + isValidParenthesis("({[]})"));
        System.out.println("Stack and HashMap:" + isValidParenthesisUsingHashMap("({[]})"));
        test();

    }


}
