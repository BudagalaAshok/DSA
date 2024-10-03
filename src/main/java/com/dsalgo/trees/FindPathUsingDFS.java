package com.dsalgo.trees;

import java.util.ArrayList;
import java.util.List;

public class FindPathUsingDFS {

    public static boolean findPathFromRootToTarget(TreeNode node,List<TreeNode> treeNodeList,int target){

        if(node==null){
            return false;
        }
        treeNodeList.add(node);
        if(node.val==target){
            return true;
        }

        if(findPathFromRootToTarget(node.left,treeNodeList,target) || findPathFromRootToTarget(node.right,treeNodeList,target)){
            return true;
        }
        treeNodeList.remove(treeNodeList.size()-1);
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        FindPathUsingDFS solution = new FindPathUsingDFS();
        List<TreeNode> path = new ArrayList<>();
        boolean found = solution.findPathFromRootToTarget(root, path, 5);

        if (found) {
            System.out.println("Path: " + path);
            System.out.println(path.toString());
        } else {
            System.out.println("Node not found");
        }
    }
}
