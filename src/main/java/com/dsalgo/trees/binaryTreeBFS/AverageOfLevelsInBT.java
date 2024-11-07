package com.dsalgo.trees.binaryTreeBFS;

import com.dsalgo.trees.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBT {

    public List<Double> findAverageLevelOrderBST(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> average = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // Number of nodes at the current level
            int levelSize = queue.size();
            double sum = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;

                //Current node having left push that into queue
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                //current node having right push that in to queue
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            //once each level got completed push the average based on the sum and no of nodes at current level
            average.add(sum/levelSize);
        }
        return average;
    }

}
