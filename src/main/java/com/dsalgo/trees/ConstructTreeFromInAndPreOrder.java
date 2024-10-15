package com.dsalgo.trees;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeFromInAndPreOrder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //Hash inorder values to get the index where it stored
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(preorder[i], i);
        }

        return buildTreeRecursively(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inOrderMap);

    }

    /*
        Here we have an initution of we have preorder so preorder first node is root node and from the inorder we will get left and right subtree
        Based on that we calculate how many elements are there at left hand side and how many elements are there at right hand side. then recursively building left and right subtree
        by adjusting the ranges
     */
    private TreeNode buildTreeRecursively(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inOrderMap) {

        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        TreeNode rootNode = new TreeNode(preorder[preStart]);
        int nodePosition = inOrderMap.get(preorder[preStart]);
        // Calculate the number of elements in the left subtree
        int numsLeft = nodePosition - inStart;
        // Recursively build the left subtree
        rootNode.left = buildTreeRecursively(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, nodePosition - 1, inOrderMap);
        // Recursively build the right subtree
        rootNode.right = buildTreeRecursively(preorder, preStart + numsLeft + 1, preEnd, inorder, nodePosition + 1, inEnd, inOrderMap);

        return rootNode;

    }

    /**
     * This was easy compared to first approach, first we store the InOrder values in an hashMap for constant lookup operation
     * Next we start the first index from PreOrder and create a node and then recursively calling left and right subtree
     * If left>right then we don't have any nodes then return null, if left==right then that is leaf node and return that node
     * Getting the inOrder index  by using the current preOrder element
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTreeByKunal(int[] preorder, int[] inorder) {

        int[] index=new int[1];
        index[0]=0;
        //First build the inorder Hashmap here we store the value and the respective index
        Map<Integer,Integer> inOrderMp=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inOrderMp.put(inorder[i],i);

        }
        return helper(preorder,inorder,0,inorder.length-1,inOrderMp,index);
    }

    public TreeNode helper(int[] preOrder,int[] inOrder,int left,int right,Map<Integer,Integer> inOrderMap,int[] index){

        if(left>right){
            return null;
        }

        int current=preOrder[index[0]];
        TreeNode node=new TreeNode(current);
        index[0]++;

        int currentIndex=inOrderMap.get(current);

        //leaf node
        if(left==right){
            return node;
        }

        //Call left and right subtree recursively to build tree
        //Here by using the current element we build left sub-tree because from the current element in the inorder array we have all elements in the left side
        //Here by using the current element we build right sub-tree because from the current element in the inorder array we have all elements in the right side
        node.left=helper(preOrder,inOrder,left,currentIndex-1,inOrderMap,index);
        node.right=helper(preOrder,inOrder,currentIndex+1,right,inOrderMap,index);
        return node;
    }


}
