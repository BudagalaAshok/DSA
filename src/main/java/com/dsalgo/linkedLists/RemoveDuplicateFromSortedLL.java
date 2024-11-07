package com.dsalgo.linkedLists;

import java.util.HashSet;
import java.util.Set;

/**
 * 	1.	Set Up Dummy and Previous Pointer:
 * 	•	Use a dummy node pointing to the head of the list.
 * 	•	Initialize prev at the dummy (to track where unique nodes should link).
 * 	2.	Traverse with Current Pointer:
 * 	•	For each node, use the current pointer to detect if it has duplicates (i.e., if current.val == current.next.val).
 * 	•	If duplicates are found, skip over all nodes with that duplicate value by advancing current until a different value is reached.
 * 	3.	Update Links to Skip Duplicates:
 * 	•	If duplicates were detected, set prev.next to current.next to bypass all duplicate nodes.
 * 	•	If no duplicates, move prev to current.
 * 	4.	Return the Resulting List:
 * 	•	After the loop, the list will contain only distinct values. Return dummy.next as the new head.
 */
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
