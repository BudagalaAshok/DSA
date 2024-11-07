package com.dsalgo.divideAndConquer;


import com.dsalgo.trees.Node;
import com.dsalgo.trees.TreeNode;

/**
 * Main idea behind to solve this problem was to apply the merge sort and sort left and right part of the linked list to do that
 * First we need to find the middle element by using slow and fast pointer technique
 * After that disconnect the link of the middle element and sort the left and right part of the linked list
 * Once both are sorted we can merge the linked list
 */
public class SortLinkedList {

    public Node sortList(Node root){

        //First check if the given root is empty or root.next is null
        if(root==null || root.next==null){
            return root;
        }

        //First find the middle element using slow and fast pointer technique
        Node middle=getMiddleNode(root);
        //Now disconnect the next link of the middle node, before that store the next node
        Node nextMiddle=middle.next;
        middle.next=null;
        Node left=sortList(root);
        Node right=sortList(nextMiddle);
        return merge(left,right);
    }

    private Node merge(Node left, Node right) {

        Node dummy=new Node(0);
        Node current= dummy;
        while (left!=null && right!=null){
            if(left.val<right.val){
                current.next=left;
                left=left.next;
            }else {
                current.next= right;
                right=right.next;
            }
            //now move the current to the next
            current=current.next;
        }

        //Now if any nodes are remaining either left or right just we link that
        if(left!=null){
            current.next= left;
        }

        if(right!=null){
            current.next= right;
        }
        return dummy.next;
    }

    private Node getMiddleNode(Node root) {

        Node slow=root;
        Node fast=root;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        SortLinkedList sortLinkedList=new SortLinkedList();
        Node node=new Node(3);
        node.next=new Node(2);
        node.next.next=new Node(1);
        node.next.next.next=new Node(4);
        node.next.next.next.next=new Node(5);
        sortLinkedList.sortList(node);
    }


}
