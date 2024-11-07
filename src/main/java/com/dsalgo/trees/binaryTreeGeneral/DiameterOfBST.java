package com.dsalgo.trees.binaryTreeGeneral;

import com.dsalgo.trees.TreeNode;

public class DiameterOfBST {
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {

        findHeight(root);
        return diameter - 1;
    }

    public int findHeight(TreeNode root) {
        //Base Case
        if (root == null) {
            return 0;
        }

        //Else find left Height and right height
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        int currentDiameter = leftHeight + rightHeight + 1;
        diameter = Math.max(currentDiameter, diameter);
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
