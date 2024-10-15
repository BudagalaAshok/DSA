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


    /**
     * 	•	Base Case:
     * 	•	If the current node is null, return null (i.e., this subtree doesn’t contain p or q).
     * 	•	If the current node is equal to p or q, return the current node (since it’s an ancestor).
     * 	•	Recursive Case:
     * 	•	Recursively search for p and q in the left and right subtrees.
     * 	•	If both left and right return non-null values, it means p is in one subtree and q is in the other, so the current node is the LCA.
     * 	•	If only one of the left or right is non-null, return that non-null node (it could be either p or q or their ancestor).
     * @param root
     * @param p
     * @param q
     * @return
     */
    //Optimal approach
    //here we are not using any extra space and we traverse the tree only once
    //we traverse the entire tree using dfs and from root node we go to the left and if it has left and then again left.if left is not there
    //then we need to move to right
    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {

        //If the given node is p or q then return that node
        if (root == null || root == p || root == q) {
            return root;
        }

        //Search for left hand side
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);

        // If p and q are found in different subtrees, current node is the LCA
        if (left != null && right != null) {
            return root;
        }

        // Otherwise, return the non-null result
        //If any one of the tree becomes null then remaining elements exists other side only no need of checking below
        return left == null ? right :left;
    }

}
