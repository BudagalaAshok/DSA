package com.dsalgo.trees.bst;


import com.dsalgo.trees.TreeNode;

/**
 * Find the minimum absolute difference between two nodes of a given tree from root
 * To solve this use inorder traversal because when we traverse via inorder all the nodes we will get in ascending order
 */
public class MinAbsDifferenceInBST {

    TreeNode prev=null;
    int minDiff=Integer.MAX_VALUE;

    public int findMinDiff(TreeNode root){
        findMin(root);
        return minDiff;
    }

    private void findMin(TreeNode root) {

        if(root==null){
            return;
        }

        //LNR
        findMin(root.left);

        if(prev!=null){
            //Finding absolute difference between current node and the previous node
            minDiff=Math.min(minDiff,Math.abs(root.val-prev.val));
        }

        //Storing the previous node to compare the difference
        prev=root;

        //Right traversal
        findMin(root.left);

    }
}
