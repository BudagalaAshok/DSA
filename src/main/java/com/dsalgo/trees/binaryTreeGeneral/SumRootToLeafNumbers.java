package com.dsalgo.trees.binaryTreeGeneral;


import com.dsalgo.trees.TreeNode;


//TC: O(n), SC: O(h)--> worst case it became O(n)
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
        /**
         * 	1.	Simulate Decimal Place Shift:
         * 	•	Multiplying by 10 shifts all current digits one place to the left, making room for the next node value at the “ones” place.
         * 	2.	Example Calculation:
         * 	•	Suppose we start at the root with value 1.
         * 	•	Moving to a child node with value 2, we compute the new path value as  1 \times 10 + 2 = 12 .
         * 	•	Moving to the next child with value 3, the path value becomes  12 \times 10 + 3 = 123 , representing the number 123.
         *
         * In summary, multiplying by 10 before adding each node’s value allows us to build the path as a number in base 10 as we traverse from the root to the leaf.
         */
        sum *= 10;
        sum += root.val;

        //If left and right is null then it is leaf node so we need to return the calculated sum up to now
        if (root.left == null && root.right == null) {
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
