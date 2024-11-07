package com.dsalgo.trees.binaryTreeBFS;

import com.dsalgo.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewOfBT {

    public void printRightView(TreeNode root) {


        //Reverse pre order traversal
        //NLR  --> RLN, here we need to traverse level by level so initially we are at 0 level
        List<TreeNode> treeNodeList = new ArrayList<>();
        rightView(root, 0, treeNodeList);

    }
    public void printLeftView(TreeNode root) {


        //pre order traversal, NLR
        List<TreeNode> treeNodeList = new ArrayList<>();
        leftView(root, 0, treeNodeList);

    }

    private void rightView(TreeNode root, int level, List<TreeNode> treeNodeList) {

        if (root == null) {
            return;
        }

        if(level== treeNodeList.size()){
            treeNodeList.add(root);
        }

        rightView(root.right,level+1,treeNodeList);
        rightView(root.left,level+1,treeNodeList);

    }

    private void leftView(TreeNode root, int level, List<TreeNode> treeNodeList) {

        if (root == null) {
            return;
        }

        if(level== treeNodeList.size()){
            treeNodeList.add(root);
        }

        leftView(root.left,level+1,treeNodeList);
        rightView(root.right,level+1,treeNodeList);
    }

    public List<Integer> rightViewOfTreeUsingIteration(TreeNode root){

        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queueNode=new LinkedList<>();
        queueNode.offer(root);

        while(!queueNode.isEmpty()){
            int levelSize=queueNode.size();

            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode=queueNode.poll();
                //for that level if it is the last element then it is the right side element of that tree
                //For that level if it is the first element then it is the left view of the tree
                if(i==levelSize-1){
                    result.add(currentNode.val);
                }

                //For left view
                /*if(i==0){
                    result.add(currentNode.val);
                }*/

                if(currentNode.left!=null){
                    queueNode.offer(currentNode.left);
                }

                if(currentNode.right!=null){
                    queueNode.offer(currentNode.right);
                }
            }

        }

        return result;

    }
}
