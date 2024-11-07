package com.dsalgo.trees.binaryTreeGeneral;

import com.dsalgo.trees.TreeNode;

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
    /**
     * Iterating via In order traversal to get the elements in ascending order
     * •	pushLeftNodes(): Goes left and pushes nodes onto the stack until it reaches a null. This prepares the stack so that the top node is the next smallest node.
     * •	next(): Pops from the stack (retrieving the smallest unvisited node). If this node has a right child, it pushes all left descendants of the right child onto the stack.
     * •	hasNext(): Simply checks if there are remaining nodes to visit by verifying if the stack is non-empty.
     * <p>
     * Summary
     * <p>
     * Using a stack and starting by going left ensures that we always have the next smallest element at the top of the stack, enabling efficient retrieval in ascending order.
     */
    Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        pushAllLeft(root);
    }

    public int next() {
        //Take the last element from stack
        TreeNode temp = stack.pop();
        if (temp.right != null) {
            pushAllLeft(temp.right);
        }
        return temp.val;

    }

    public void pushAllLeft(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }


}
