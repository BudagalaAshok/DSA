package com.dsalgo.linkedLists;

import org.apache.commons.lang3.tuple.Pair;

public class ReverseSubListLinkedList {

    public static Pair<ListNode, ListNode> reverse(ListNode head, int count) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode temp = null;

        while (count > 0) {
            count--;
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Return the new head (prev) and the node after the reversed part (temp)
        return Pair.of(prev,curr);
    }


    //Reverse Linked List || rotate the linked list nodes between left and right values
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode leftNode = head;
        ListNode beforeLeftNode = null;

        // Move to the node just before `left`
        for (int i = 1; i < left; i++) {
            beforeLeftNode = leftNode;
            leftNode = leftNode.next;
        }

        // Reverse the nodes between `left` and `right`
        Pair<ListNode, ListNode> result = reverse(leftNode, right - left + 1);
        ListNode rightNode = result.getKey();
        ListNode afterRightNode = result.getValue();

        // Reconnect the reversed part with the rest of the list
        if (beforeLeftNode != null) {
            beforeLeftNode.next = rightNode;
        } else {
            head = rightNode; // If `left` was 1, the new head is `rightNode`
        }
        leftNode.next = afterRightNode;

        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
