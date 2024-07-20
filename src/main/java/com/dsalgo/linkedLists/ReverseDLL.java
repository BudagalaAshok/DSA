package com.dsalgo.linkedLists;

import java.util.Stack;

public class ReverseDLL {

    //Approach using stack

    //Iterate each and every element until we reaches at the end of DLL and push element to the stack
    //Again do one more iteration this time we pop the element from the stack and replace the element at the stack
    DLLNode reverseDLLUsingStack(DLLNode head) {

        DLLNode temp = head;

        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {

            int element = stack.pop();
            temp.data = element;
            temp = temp.next;
        }

        return head;

    }

    //Instead of traversing two times we can reverse in a single loop by interchanging the prev and next pointers
    DLLNode reverseDLL(DLLNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        DLLNode prev = null;

        DLLNode current = head;

        while (current != null) {

            prev = current.prev;
            current.prev = current.next;
            current.next = prev;

            //Move to the next node
            current = current.prev;

        }

        //The final node in the original list becomes the new head after reversal
        return prev.prev;

    }


}


class DLLNode {

    int data;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}