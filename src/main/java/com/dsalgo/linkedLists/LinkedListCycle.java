package com.dsalgo.linkedLists;

public class LinkedListCycle {

    public boolean hasCycle(Node head){

        if(head==null || head.next==null){
            return false;
        }

        //If slow and fast meets any points then we can tell there is a cycle exists,
        //If we don't have cycle then slow and fast pointers never meet
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;

    }
}
