package com.dsalgo.trees.binaryTreeGeneral;

import com.dsalgo.trees.TreeNode;

public class CountTheCompleteTreeNodes {

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = getLeftHeight(root.left);
        int rightHeight = getRightHeight(root.right);

        //If both left and right heights are equal then both are perfectly balanced then we can calcuate using the formula 2to(power of h)-1
        if (leftHeight == rightHeight) {
            return (2 << (leftHeight + 1)) - 1;
        }
        //else recursively calculates the height of the tree
        return 1 + countNodes(root.left) + countNodes(root.right);

    }

    //Calculate the height of the tree by going the node one by one
    //Calculate the height of the tree by going the node one by one
    public int getLeftHeight(TreeNode node){
        int height=0;
        while(node!=null){
            height++;
            node=node.left;
        }
        return height;
    }

    public int getRightHeight(TreeNode node){
        int height=0;
        while(node!=null){
            height++;
            node=node.right;
        }
        return height;
    }
}
