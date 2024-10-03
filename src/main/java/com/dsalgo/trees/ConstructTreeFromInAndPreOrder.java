package com.dsalgo.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInAndPreOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //Hash inorder values to get the index where it stored
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(preorder[i], i);
        }

        return buildTreeRecursively(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inOrderMap);

    }

    /*
        Here we have an initution of we have preorder so preorder first node is root node and from the inorder we will get left and right subtree
        Based on that we calculate how many elements are there at left hand side and how many elements are there at right hand side. then recursively building left and right subtree
        by adjusting the ranges
     */
    private TreeNode buildTreeRecursively(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inOrderMap) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode rootNode = new TreeNode(preorder[preStart]);
        int nodePosition = inOrderMap.get(preorder[preStart]);
        // Calculate the number of elements in the left subtree
        int numsLeft = nodePosition - inStart;
        // Recursively build the left subtree
        rootNode.left = buildTreeRecursively(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, nodePosition - 1, inOrderMap);
        // Recursively build the right subtree
        rootNode.right = buildTreeRecursively(preorder, preStart + numsLeft + 1, preEnd, inorder, nodePosition + 1, inEnd, inOrderMap);

        return rootNode;

    }


}
