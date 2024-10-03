package com.dsalgo.linkedLists;

import java.util.PriorityQueue;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {

        ListNode temp = head;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        while (temp != null) {
            priorityQueue.add(temp.val);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(-1);
        while (!priorityQueue.isEmpty()) {
            int element = priorityQueue.poll();
            dummy.next = new ListNode(element);
            dummy = dummy.next;
        }

        return dummy.next;
    }

    public ListNode partitionLL(ListNode head, int x) {
        // Create two dummy nodes to start the less and greater lists
        ListNode temp = head;
        ListNode list1 = new ListNode(-1);
        ListNode dummy = list1;
        ListNode list2 = new ListNode(-1);
        ListNode dummy2 = list2;
        //Traverse the original list
        while (temp != null) {
            if (temp.val < x) {
                list1.next = new ListNode(temp.val);
                list1 = list1.next;
            } else {
                list2.next = new ListNode(temp.val);
                list2 = list2.next;
            }
            temp=temp.next;
        }
        //Connect the first and second list
        list1.next = dummy2.next;
        //Point second list next to null
        list2.next=null;
        //return the new head which is the start of first list
        return dummy.next;
    }
}
