package com.dsalgo.divideAndConquer;

import com.dsalgo.trees.TreeNode;

/**
 * Initution behind this problem is to find the mid value because it is the root of the tree
 * and before mid left tree and after mid right sub tree. Now create a root node from the mid value and recursively apply
 * the same for both left and right sub trees
 */
public class ConvertSortedArrayIntoBST {

    public TreeNode convertArrayIntoBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        //Start is 0 and end is array length
       return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {

        //Base if start is greater than end that means we need to stop we don't have any nodes to left to process
        if(start>end){
            return null;
        }

        //Calculate Mid value
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(nums[mid]);
        //Now build left sub tree by using left part
        root.left=buildBST(nums,start,mid-1);
        //Build right sub-tree by using right part
        root.right=buildBST(nums,mid+1,end);
        return root;
    }

}
