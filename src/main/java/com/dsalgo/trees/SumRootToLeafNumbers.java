package com.dsalgo.trees;


public class SumRootToLeafNumbers {

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    //Here we are using dfs to traverse the tree
    public int dfs(TreeNode root, int sum) {

        //If the given root is empty then directly return the sum as zero
        if (root == null) {
            return 0;
        }
        //if value is there we need to convert in to base decimal system
        sum *= 10;
        sum += root.val;

        //If left and right is null then it is leaf node so we need to return the calculated sum up to now
        if (root.left == null || root.right == null) {
            return sum;
        }
        //now calculate the left tree sum
        int leftSum = dfs(root.left, sum);
        //now calculate the right tree sum
        int rightSum = dfs(root.right, sum);
        //return the sum of left and right tree once traversal is done
        return leftSum + rightSum;
    }

}
