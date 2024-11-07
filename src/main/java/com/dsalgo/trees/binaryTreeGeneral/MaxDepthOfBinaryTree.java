package com.dsalgo.trees.binaryTreeGeneral;

import com.dsalgo.trees.TreeNode;


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
public class MaxDepthOfBinaryTree {

    public int maxDepth(TreeNode node) {
        //Base case
        if (node == null) {
            return 0;
        }

        //From the current node depth will be calculated as Max(left,right)
        //So it will be 1 + max(left ,right)

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

}
