package com.dsalgo.trees;

import java.util.ArrayList;
import java.util.List;
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

    // List to store the nodes in pre-order traversal
    List<TreeNode> nodeList = new ArrayList<>();

    public void flattenTreeUsingBruteForce(TreeNode root) {
        if (root == null) {
            return;
        }

        // Step 1: Traverse the tree in pre-order and store the nodes in a list
        preOrderTraversal(root);

        // Step 2: Reconstruct the tree into a linked list
        for (int i = 0; i < nodeList.size() - 1; i++) {
            TreeNode current = nodeList.get(i);
            TreeNode next = nodeList.get(i + 1);
            current.left = null; // Set left to null
            current.right = next; // Connect the right to the next node
        }
    }

    // Pre-order traversal to store nodes in a list
    private void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        nodeList.add(node); // Store the current node
        preOrderTraversal(node.left); // Traverse the left subtree
        preOrderTraversal(node.right); // Traverse the right subtree
    }



    //Optimal approach using level order traversal
    //iterate left side of the tree until reach the right most node and then connect this right to root node right
    //and then continue
    public void flattenTreeLL(TreeNode node) {
        // Initialize a pointer
        // 'curr' to the root of the tree
        //Don't change the root
        TreeNode curr = node;

        // Iterate until 'curr'
        // becomes NULL
        while (curr != null) {
            // Check if the current, we need to go to left and find the empty space on the right node
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
