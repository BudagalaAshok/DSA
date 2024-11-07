package com.dsalgo.trees.binaryTreeGeneral;

import com.dsalgo.trees.TreeNode;

public class SerializeAndBinaryTree {

    public String serializeTree(TreeNode node) {

        StringBuilder result = new StringBuilder();
        serializeHelper(node, result);
        return result.toString();
    }


    /**
     * 1.	Preorder Traversal for Serialization:
     * 	•	For serialization, we perform a preorder traversal (root, left, right) to record the nodes.
     * 	•	This traversal is suitable because, in a BST, the order of nodes in preorder helps us preserve the structure, enabling correct reconstruction during deserialization.
     * @param node
     * @param result
     */
    private void serializeHelper(TreeNode node, StringBuilder result) {

        if (node == null) {
            return;
        }
        result.append(node.val).append(",");
        serializeHelper(node.left, result);
        serializeHelper(node.right, result);
    }

    public TreeNode deserializeTree(String treeString) {
        if (treeString.isEmpty()) {
            return null;
        }

        int[] index = new int[0];
        index[0] = 0;
        String[] nodes = treeString.split(",");
        return deserializeHelper(nodes, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /**
     * 2.	Deserialization Using BST Properties:
     * 	•	During deserialization, we can use the BST property to know where each node should be placed:
     * 	•	Every node’s left child should be smaller than the node.
     * 	•	Every node’s right child should be larger than the node.
     * 	•	We use the range constraints based on these properties to ensure correct placement of nodes while reconstructing the tree.
     * @param nodes
     * @param index
     * @param minValue
     * @param maxValue
     * @return
     */
    private TreeNode deserializeHelper(String[] nodes, int[] index, int minValue, int maxValue) {

        //Base case if index value is reached to the last node then we are done
        if(index[0]==nodes.length){
            return null;
        }

        int val=Integer.parseInt(nodes[index[0]]);
        //Checking the boundaries of the current value
        if(val<minValue || val>maxValue){
            return null;
        }

        TreeNode node=new TreeNode(val);
        index[0]++;

        // Recur for left and right children within the updated range
        node.left=deserializeHelper(nodes,index,minValue,val);
        node.right=deserializeHelper(nodes,index,val,maxValue);
        return node;

    }


}
