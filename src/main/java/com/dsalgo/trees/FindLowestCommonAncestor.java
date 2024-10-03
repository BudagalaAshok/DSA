package com.dsalgo.trees;

import java.util.ArrayList;
import java.util.List;

public class FindLowestCommonAncestor {

    public TreeNode findLCAWithExtraSpace(TreeNode treeNode, TreeNode p, TreeNode q) {

        List<TreeNode> pPathList = new ArrayList<>();
        FindPathUsingDFS.findPathFromRootToTarget(treeNode, pPathList, p.val);

        List<TreeNode> qPathList = new ArrayList<>();
        FindPathUsingDFS.findPathFromRootToTarget(treeNode, qPathList, q.val);

        int size = Math.min(pPathList.size(), qPathList.size());
        for (int i = 0; i < size; i++) {
            if (pPathList.get(i).val == qPathList.get(i).val) {
                continue;
            }
            return pPathList.get(i - 1);
        }

        return null;
    }


    //Optimal approach
    //here we are not using any extra space and we traverse the tree only once
    //we traverse the entire tree using dfs and from root node we go to the left and if it has left and then again left.if left is not there
    //then we need to move to right
    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        //Search for left hand side
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        //If left was null then take the right value
        if (left == null) {
            return right;
        }
        //If right was null then take the left value
        else if (right == null) {
            return left;
        }
        //If both are not null then we found the actual node
        return root;
    }

}
