package com.dsalgo.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class EvalReversePolishNotation {

    //Lambda function with Map and value as function
    private static final Map<String, BiFunction<Integer, Integer, Integer>> OPERATIONS = new HashMap<>();

    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> a - b);
        OPERATIONS.put("/", (a, b) -> a / b);
        OPERATIONS.put("*", (a, b) -> a * b);
    }

    public static int evaluateRPNUsingLambda(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {

            if (!OPERATIONS.containsKey(token)) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            int number2 = stack.pop();
            int number1 = stack.pop();
            BiFunction<Integer, Integer, Integer> operation;
            //Here based on the operator we are fetching relevant function
            operation = OPERATIONS.get(token);
            //After that apply that function and push the result to stack
            int result = operation.apply(number1, number2);
            stack.push(result);
        }
        return stack.pop();
    }


    //Here whenever we encounter any operator like +,-,*,/ we pop first two elements from the stack and apply the operation and push the result to stack
    //If we encounter operand directly we push that operand to the stack
    public static int evaluateRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            int op1 = 0;
            int op2 = 0;
            switch (token) {
                case "+":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op1 + op2);
                    break;
                case "-":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2 - op1);
                    break;
                case "*":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op1 * op2);
                    break;
                case "/":
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2 / op1);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }

        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println("Result is :" + evaluateRPN(tokens));
        System.out.println("Evalute RPN using Lamda function:"+evaluateRPNUsingLambda(tokens));
    }


}
