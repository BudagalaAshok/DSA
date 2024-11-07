package com.dsalgo.trees.binaryTreeGeneral;

import com.dsalgo.trees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInAndPostOrder {

    /**
     * InOrder -> LNR
     * PostOrder -> LRN
     * Here we are traversing from the end of the post order array because for the node we have right first and then node
     * the key difference is that in the postorder traversal, the last element is the root of the tree. Thus, you will build the tree by starting from the last element
     * of the postorder array and moving backwards.
     * @param inOrder
     * @param postOrder
     * @return
     */
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {

        //postIndex starts from the last element of the postorder array (the root of the tree).
        int[] index = new int[1];
        index[0] = postOrder.length - 1;
        //First construct the inOrder map for constant lookup
        Map<Integer, Integer> inOrderMp = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inOrderMp.put(inOrder[i], i);

        }

        return helper(inOrder, postOrder, 0, postOrder.length - 1, inOrderMp, index);

    }

    private TreeNode helper(int[] inOrder, int[] postOrder, int left, int right, Map<Integer, Integer> inOrderMp, int[] index) {

        //BaseCase
        if (left > right) {
            return null;
        }

        int current = postOrder[index[0]];
        index[0]--;
        TreeNode node = new TreeNode(current);

        if (left == right) {
            return node;
        }
        //You recursively build the right subtree first (since the root comes after the right
        // subtree in postorder traversal) and then the left subtree.
        int currentIndex = inOrderMp.get(current);
        node.right = helper(inOrder, postOrder, currentIndex + 1, right, inOrderMp, index);
        node.left = helper(inOrder, postOrder, left, currentIndex - 1, inOrderMp, index);
        return node;
    }
}
