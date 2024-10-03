package com.dsalgo.trees;

public class MaxPathSum {


    public int findMaxPathSum(TreeNode root){

        int[] maxSum=new int[1];
        maxSum[0]=Integer.MIN_VALUE;
        findMaxSum(root,maxSum);
        return maxSum[0];
    }

    private int findMaxSum(TreeNode root, int[] maxSum) {

        if(root==null){
            return 0;
        }

        //First find the leftSum from root node to left path
        int leftSum=Math.max(0,findMaxSum(root.left,maxSum));
        //First find the rightSum from root node to right path
        int rightSum=Math.max(0,findMaxSum(root.right,maxSum));
        // Update the overall maximum
        // path sum including the current node
        maxSum[0]=Math.max(maxSum[0],root.val+leftSum+rightSum);

        // Return the maximum sum considering
        // only one branch (either left or right)
        // along with the current node
        return Math.max(leftSum,rightSum)+root.val;


    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.left.right.right.right = new TreeNode(7);

        // Creating an instance of the Solution class
        MaxPathSum solution = new MaxPathSum();

        // Finding and printing the maximum path sum
        int maxPathSum = solution.findMaxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxPathSum);
    }


}
