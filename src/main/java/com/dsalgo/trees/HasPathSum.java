package com.dsalgo.trees;

public class HasPathSum {

    /**
     * Checking whether we have targetSum from root node to leaf node either from left or right
     * @param root
     * @param targetSum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {

        //If root is null then there is no path exists
        if(root==null){
            return false;
        }

        //Check the node is leaf node by comparing left and right nodes having null
        //and checking the value remaining is equal to the targetSum
        if(root.left==null && root.right==null){
            return targetSum==root.val;
        }

        int remainingSum=targetSum-root.val;
        //Checking either left or right
        return hasPathSum(root.left,remainingSum) || hasPathSum(root.right,remainingSum);
    }
}
