package com.dsalgo.trees;

import java.util.ArrayList;
import java.util.List;

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
}
