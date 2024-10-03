package com.dsalgo.trees;

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
        return isSymmetricalHelper(left.left, right.right) && isSymmetricalHelper(left.right, right.left);
    }


}
