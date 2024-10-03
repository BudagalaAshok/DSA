package com.dsalgo.trees;

public class CountTheCompleteTreeNodes {

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        //If both left and right heights are equal then both are perfectly balanced then we can calcuate using the formula 2to(power of h)-1
        if (leftHeight == rightHeight) {
            return (1 << (leftHeight + 1)) - 1;
        }
        //else recursively calculates the height of the tree
        return 1 + countNodes(root.left) + countNodes(root.right);

    }

    //Calculate the height of the tree by going the node one by one
    public int getHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }
}
