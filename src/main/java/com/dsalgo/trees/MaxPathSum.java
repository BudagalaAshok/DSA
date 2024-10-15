package com.dsalgo.trees;

public class MaxPathSum {


    /**
     * In entire tree what was the max Sum if it exists in left hand side or right hand side
     *
     * @param root
     * @return
     */
    private int maxSum = Integer.MIN_VALUE;

    public int findMaxPathSum(TreeNode root) {
        findMaxSum(root);
        return maxSum;
    }

    private int findMaxSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        //First find the leftSum from root node to left path
        int leftSum = Math.max(0, findMaxSum(root.left));
        //First find the rightSum from root node to right path
        int rightSum = Math.max(0, findMaxSum(root.right));
        // Update the overall maximum
        // path sum including the current node
        int currentSum = root.val + leftSum + rightSum;
        maxSum = Math.max(maxSum, currentSum);

        // Return the maximum sum considering
        // only one branch (either left or right)
        // along with the current node
        /** node.val + Math.max(leftMax, rightMax) is returned to the parent because a path extending to the parent
         can only include one of the subtrees, not both.
         */
        return Math.max(leftSum, rightSum) + root.val;


    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        /*root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);*/

        // Creating an instance of the Solution class
        MaxPathSum solution = new MaxPathSum();

        // Finding and printing the maximum path sum
        int maxPathSum = solution.findMaxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }


}
