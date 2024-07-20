package com.dsalgo.stacks;

import java.util.Stack;

public class MinStackUsingLists {

    private Stack<int[]> stack=new Stack<>();
    public MinStackUsingLists() {
    }

    public void push(int val){

        if(stack.isEmpty()) {
            stack.push(new int[]{val, val});
        }else{
            int minVal=Math.min(val,stack.peek()[1]);
            stack.push(new int[]{val,minVal});
        }

    }

    public void pop(){
        stack.pop();
    }

    public int top(){
        return stack.peek()[0];
    }
    public int getMin(){
        return stack.peek()[1];
    }
}
