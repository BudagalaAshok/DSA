package com.dsalgo.trees.binaryTreeGeneral;

import com.dsalgo.trees.Node;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextPointersEachNode {

    public Node connect(Node root) {

        if (root == null) {
            return null;
        }

        Node current = root;
        Node dummy = new Node(0);
        Node prev = dummy;

        //This loop is used to iterate level by level
        while (current != null) {

            //This loop is used to iterate nodes in that level
            while (current != null) {

                if (current.left != null) {
                    prev.next = current.left;
                    prev = prev.next;
                }

                if (current.right != null) {
                    prev.next = current.right;
                    prev = prev.next;
                }

                current = current.next;
            }

            //while moving to the next level we are pointing last node in that level to null
            //And also moving dummy head to next to point the actual node
            //marking dummy as Prev
            current = dummy.next;
            dummy.next = null;
            prev = dummy;
        }

        return root;

    }

    //Bruteforce approach using queue with extra space

    public Node connectUsingExtraSpace(Node root) {

        if (root == null) {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            ;

            while (size-- > 0) {
                Node current = queue.remove();
                Node dummy = new Node(0);
                dummy.next = current;
                dummy = dummy.next;

                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

        }
        return root;
    }


    //Another solution to achieve the same using BFS

    /** TC: O(n) and space C: O(h) ,worst case : O(n)
     * Iterate through each level of the tree. The outer loop continues until no more levels are below (mostleft.left is NULL).
     * Inside the outer loop, there is an inner loop that traverses each node on the current level. It starts with the current variable initialized as the leftmost node of the current level.
     * Within the inner loop, the algorithm establishes the connections between nodes.
     * First connection: It connects the current node’s left child to its right child by assigning current.left.next to current.right.
     * Second connection: If there is a next node (current.next) on the same level, it connects the current node’s right child to the left child of its next node by assigning current.right.next to current.next.left.
     * After connecting the nodes on the current level, the current moves to the next node on the same level. This process continues until the end of the level is reached (current becomes NULL).
     * Once the inner loop completes, the mostleft is updated to the left child of the previous mostleft node. This moves the traversal down to the next level.
     * The outer loop repeats the above steps until there are no more levels below (mostleft.left is NULL).
     * Finally, the modified root node is returned.
     * @param root
     * @return
     */
    public Node populateNextPointers(Node root) {

        if (root == null) {
            return root;
        }

        Node leftMost = root;
        //Outer loop for each level
        while (leftMost != null) {
            Node current = leftMost;

            while (current != null) {

                current.left.next=current.right;

                if(current.next!=null){
                    current.right.next=current.next.left;
                }
                current=current.next;

            }

            leftMost = leftMost.left;
        }
        return root;
    }

}
