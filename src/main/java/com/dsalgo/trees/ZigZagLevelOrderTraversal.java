package com.dsalgo.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> orderLevelList = new ArrayList<>();
        if (root == null) {
            return orderLevelList;
        }
        boolean leftToRight=true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int level= queue.size();;
            List<Integer> values=new ArrayList<>();
            for (int i = 0; i < level; i++) {
                TreeNode current=queue.poll();

                if(leftToRight){
                    values.add(current.val);
                }else{
                    //To reverse order we are inserting every element at starting postition
                    values.add(0, current.val);
                }
                if(current.left!=null){
                    queue.add(current.left);
                }
                if(current.right!=null){
                    queue.add(current.right);
                }

            }
            //Reversing direction alternatively to perform zig zag level order
            leftToRight=!leftToRight;
            orderLevelList.add(values);
        }

        return orderLevelList;

    }

}
