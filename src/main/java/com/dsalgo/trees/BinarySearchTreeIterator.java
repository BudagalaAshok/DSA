package com.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinarySearchTreeIterator {

 /*   Queue<Integer> queue;

    public BinarySearchTreeIterator(TreeNode root) {
        queue=new LinkedList<>();
        inOrderTraversal(root,queue);

    }

    public void inOrderTraversal(TreeNode root, Queue<Integer> queue){
        if(root!=null){
            inOrderTraversal(root.left,queue);
            queue.add(root.val);
            inOrderTraversal(root.right,queue);
        }
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {

        return !queue.isEmpty();
    }
    */

    //This was the optimal solution because it use O(h) as space complexity and O(1) for next (Amoritized analysis) and O(1) hasNext just checking empty
    Stack<TreeNode> stack=new Stack<>();
    public BinarySearchTreeIterator(TreeNode root){
        pushAllLeft(root);
    }

    public int next(){
        //Take the last element from stack
        TreeNode temp=stack.pop();
        if(temp.right!=null){
            pushAllLeft(temp.right);
        }
        return temp.val;

    }

    public void pushAllLeft(TreeNode root){
        while(root!=null){
            stack.push(root);
            root=root.left;
        }
    }


}
