package com.dsalgo.linkedLists;


/**
 * 	1.	Create a Gap of n Nodes: Move the fast pointer n nodes ahead. This gap will ensure that when the fast pointer reaches the end of the list,
 * 	the slow pointer will be exactly at the node just before the nth node from the end.
 * 	2.	Move Both Pointers Until Fast Reaches the End: By moving both pointers one node at a time until the fast pointer hits the end (fast != null),
 * 	the slow pointer ends up right before the nth node from the end.
 * 	3.	Remove the nth Node: Now that the slow pointer is right before the target node, we can skip it by adjusting the pointer connection,
 * 	effectively removing it from the list.
 */
public class RemoveNthNodeFromEndOfLL {


    //By using slow and fast pointer technique
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy=new ListNode(0);
        dummy.next=head;

        //fast and slow points to a dummy node and dummy.next poinst to head
        ListNode fast=dummy;
        ListNode slow=dummy;

        //Move fast pointer by n+1 position
        for(int i=0;i<=n;i++){
            fast=fast.next;
        }

        //After that while fast!=null move the slow pointer and fast pointer
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }

        //once done point slow.next=slow.next.next
        slow.next=slow.next.next;

        //return the head;
        return dummy.next;

    }

}
