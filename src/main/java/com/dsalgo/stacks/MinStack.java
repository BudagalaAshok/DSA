package com.dsalgo.stacks;

import java.util.Stack;

public class MinStack {

    //Here again we are using stacks to implement this, one is to store actual values and another one is to store min values

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack(){

         stack=new Stack<>();
         minStack=new Stack<>();

    }

    public void push(int val){

        stack.push(val);
        minStack.push(Math.min(val,minStack.isEmpty() ? val:minStack.peek()));

    }


    public void pop(){

        //checking stack top and min stack top elements both are same then only removing from minStack
        if(stack.peek().equals(minStack.peek())){
            minStack.pop();
        }

        stack.pop();

    }

    public int top(){
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack1=new MinStack();
        minStack1.push(-3);
        minStack1.push(-2);
        minStack1.push(0);
        minStack1.pop();
        int topValue=minStack1.top();
        int minValue=minStack1.getMin();
        System.out.println("Top Value is :"+topValue+" and Min Value was :"+minValue);

    }

}
