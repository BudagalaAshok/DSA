package com.dsalgo.trees;

import java.util.Stack;

public class FlattenTreeIntoLinkedList {

    TreeNode prev = null;

    //Brute force we can solve using recursion and reverse preorder
    // Right, Left and Node
    public void flatten(TreeNode node) {

        if (node == null) {
            return;
        }
        flatten(node.right);
        flatten(node.left);

        // At this point, both left and right
        // subtrees are flattened, and 'prev'
        // is pointing to the rightmost node
        // in the flattened right subtree.

        // Set the right child of
        // the current node to 'prev'.
        node.right = prev;

        // Set the left child of the
        // current node to null.
        node.left = null;
        // Update 'prev' to the current
        // node for the next iteration.
        prev = node;

    }

    public void flattenUsingIteration(TreeNode node) {

        if (node == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            if (current.left != null) {
                stack.push(current.left);
            }

            if (current.right != null) {
                stack.push(current.right);
            }

            if (!stack.isEmpty()) {
                // Connect the right child to
                // the next node in the stack.
                current.right = stack.peek();
            }
            // Set the left child to null to
            // form a right-oriented linked list.
            current.left = null;
        }

    }

    //Optimal approach using level order traversal
    //iterate left side of the tree until reach the right most node and then connect this right to root node right
    //and then continue
    public void flattenTreeLL(TreeNode node) {
        // Initialize a pointer
        // 'curr' to the root of the tree
        TreeNode curr = node;

        // Iterate until 'curr'
        // becomes NULL
        while (curr != null) {
            // Check if the current
            // node has a left child
            if (curr.left != null) {
                // If yes, find the rightmost
                // node in the left subtree
                TreeNode pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                // Connect the rightmost node in
                // the left subtree to the current
                // node's right child
                pre.right = curr.right;

                // Move the entire left subtree to the
                // right child of the current node
                curr.right = curr.left;

                // Set the left child of
                // the current node to NULL
                curr.left = null;
            }

            // Move to the next node
            // on the right side
            curr = curr.right;
        }
    }


}
