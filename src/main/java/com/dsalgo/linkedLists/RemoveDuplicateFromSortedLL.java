package com.dsalgo.linkedLists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateFromSortedLL {

    public ListNode deleteDuplicates(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode dummy=new ListNode(-1);
        ListNode temp=head;
        Set<Integer> listNodeSet=new HashSet<>();
        while(temp!=null){

            if(!listNodeSet.contains(temp.val)){
                dummy.next=new ListNode(temp.val);
            }
            temp=temp.next;
        }
        return dummy.next;

    }

}
