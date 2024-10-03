package com.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTraversals {

    //NLR
    public void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    //LRN
    public void postOrderTraversal(TreeNode root) {
        if (root != null) {
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
            System.out.println(root.val);
        }
    }

    //LDR
    public void inOrderTraversal(TreeNode root) {
        if (root != null) {
            preOrderTraversal(root.left);
            System.out.println(root.val);
            preOrderTraversal(root.right);
        }
    }

    //We will go via level by level and from left to right
    public void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
