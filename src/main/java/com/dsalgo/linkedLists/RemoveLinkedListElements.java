package com.dsalgo.linkedLists;

public class RemoveLinkedListElements {


    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode temp = head;
        while (temp != null) {

            if(temp.val!=val){
                dummy.next=new ListNode(temp.val);
            }
            dummy=dummy.next;
            temp=temp.next;

        }
        return dummy.next;
    }

}
