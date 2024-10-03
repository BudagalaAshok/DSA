package com.dsalgo.trees;

public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode node) {
        //Base case
        if (node == null) {
            return 0;
        }

        //From the current node depth will be calculated as Max(left,right)
        //So it will be 1 + max(left ,right)

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

}
