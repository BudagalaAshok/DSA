package com.dsalgo.trees.binaryTreeGeneral;

import com.dsalgo.trees.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Same Tree: Focuses on identity (exact match between two trees).
 */
public class SameTree {

    /**
     * Time Complexity
     *
     * 	•	 O(n) : We must visit each node in the tree once to compute its depth. Since we traverse all nodes, where  n  is the number of nodes in the tree, the time complexity is linear.
     *
     * Space Complexity
     *
     * 	•	 O(h) : This represents the space required for the recursive call stack, where  h  is the height of the tree.
     * 	•	In the worst case (for a skewed tree),  h  can be  n , making the space complexity  O(n) .
     * 	•	In the best case (for a balanced tree),  h  is  \log(n) , so the space complexity is  O(\log(n)) .
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {

        //If both nodes are null
        if (p == null && q == null) {
            return true;
        }

        //If any one of the node is null
        if (p == null || q == null) {
            return false;
        }

        //If both nodes are not null then need to check the values and then recursively compare both left and right
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    //we can solve same problem using iteratively by using queue and we can go level by level from left to right
    public boolean isSameTreeUsingIteratively(TreeNode node) {
        if (node == null) {
            return true;
        }
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.add(node.left);
        treeNodeQueue.add(node.right);

        while (!treeNodeQueue.isEmpty()) {

            TreeNode left=treeNodeQueue.poll();
            TreeNode right=treeNodeQueue.poll();

            if(left==null && right==null){
                return true;
            }
            if(left==null || right==null || left.val!=right.val){
                return false;
            }

            treeNodeQueue.add(left.left);
            treeNodeQueue.add(right.right);

            treeNodeQueue.add(left.right);
            treeNodeQueue.add(right.left);
        }
        return true;
    }

}
