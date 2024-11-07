package com.dsalgo.trees.binaryTreeGeneral;

import com.dsalgo.trees.TreeNode;

/**
 * Symmetric Tree: Focuses on mirroring (left vs. right).
 */
public class IsSymmetricalTree {

    public boolean isSymmetrical(TreeNode root) {
        return root == null || isSymmetricalHelper(root.left, root.right);
    }

    /*
     * Simultaneously checking both left and right subtree values are equal or right
     * At the center it should be the mirror image of both left and right subtrees
     */
    private boolean isSymmetricalHelper(TreeNode left, TreeNode right) {
        //If any one of the nodes are null then check for equality for left and right

        //Base cases
        if(left==null && right==null){
            return true;
        }

        if (left == null || right == null) {
            return false;
        }
        //Then check for the value
        if (left.val != right.val) {
            return false;
        }

        //Check Simultaneously on left.left and right.right
        //right.left and left.right
        /**
         * In a recursive approach, this simultaneous check typically looks like this:
         *
         * 	1.	Compare the left and right nodes of the root to see if they are the same.
         * 	2.	Recursively check:
         * 	•	The left subtree of the left node with the right subtree of the right node.
         * 	•	The right subtree of the left node with the left subtree of the right node.
         *
         * This simultaneous comparison guarantees that the two sides mirror each other, making it possible to efficiently verify symmetry.
         */
        return isSymmetricalHelper(left.left, right.right) && isSymmetricalHelper(left.right, right.left);
    }


}
