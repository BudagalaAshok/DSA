package com.dsalgo.trees;

public class ValidateBST {

    //To solve this we need boundaries i.e lower boundary and upper boundary
    //We can start with as null
    public boolean isValidBST(TreeNode root) {
       return isValid(root,null,null);
    }

    /*
     * Here the binary tree properties are from the left side of tree always less than the root value
     * For the right side of the tree always greater than the root value
     */
    private boolean isValid(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }

        if ((low != null && root.val <= low) || (high != null && root.val >= high)) {
            return false;
        }
      return isValid(root.left,low,root.val) && isValid(root.right,root.val,high);
    }

}
