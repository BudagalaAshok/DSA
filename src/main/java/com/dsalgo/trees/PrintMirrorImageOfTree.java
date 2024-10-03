package com.dsalgo.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintMirrorImageOfTree {

    public void printMirrorOfTree(TreeNode node) {

        //Base case
        if (node == null) {
            return;
        }

        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        //recursively call the function to do the same for other nodes
        printMirrorOfTree(node.left);
        printMirrorOfTree(node.right);
    }

    public void inOrderTraversal(TreeNode node){

        if(node==null){
            return;
        }

        inOrderTraversal(node.left);
        System.out.println("Data was :"+node.val);
        inOrderTraversal(node.right);

    }

    //Invert the tree using iterative approach
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Swap the left and right children
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Add the children to the queue for further processing
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {

        TreeNode node=new TreeNode(10);
        TreeNode left=new TreeNode(5);
        TreeNode right=new TreeNode(12);
        node.left=left;
        node.right=right;
        PrintMirrorImageOfTree imageOfTree=new PrintMirrorImageOfTree();
        imageOfTree.printMirrorOfTree(node);
        imageOfTree.inOrderTraversal(node);
    }

}
