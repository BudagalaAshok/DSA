package com.dsalgo.linkedLists;

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
