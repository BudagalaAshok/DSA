package com.dsalgo.twoPointers;

import com.dsalgo.trees.Node;

public class RemoveNthNodeFromEndOfLinkedList {

    //Using Two pointers
    public Node removeNthNodeFromEndOfLL(Node head, int n){

        Node left=head;
        Node right=head;

        //Move right pointer to the n steps ahead
        for (int i = 0; i < n; i++) {
            right=right.next;
        }

        if(right==null){
            return head.next;
        }

        //Now move both left and right pointers until right.next!=null
        while (right.next!=null){
            left=left.next;
            right=right.next;

        }

        //Once this loops got completed then our left is before the nth node
        left.next=left.next.next;
        return head;
    }
}
