package com.dsalgo.trees.bst;

import com.dsalgo.trees.TreeNode;

/*
 * It is 1 based indexing, Here also we need to traverse the tree with inorder traversal
 * If we do that then we will get the elements in ascending order so that we can find the kth position element easily
 * we keep a track of element whenever we read and if we compare with the k value
 */
public class KthSmallestElementInBST {
    private int counter = 0;
    private int result = 0;

    public int getKSmallestElement(TreeNode treeNode, int k) {
        getSmallestElement(treeNode, k);
        return result;
    }

    private void getSmallestElement(TreeNode treeNode, int k) {
        if (treeNode == null) {
            return;
        }
        getSmallestElement(treeNode.left, k);
        counter++;
        if (counter == k) {
            result = treeNode.val;
            return;
        }
        getSmallestElement(treeNode.right, k);
    }

}
