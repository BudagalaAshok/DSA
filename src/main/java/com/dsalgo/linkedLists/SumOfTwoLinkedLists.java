package com.dsalgo.linkedLists;

public class SumOfTwoLinkedLists {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0); // Dummy node to serve as the head of the result list
        ListNode current = dummy;
        int carry = 0; // Initialize carry to 0

        // Traverse both lists until one of them becomes null
        while (l1 != null || l2 != null) {
            // If l1 is not null, add its value to carry
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            // If l2 is not null, add its value to carry
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            // Create a new node with the sum (carry % 10) and move to the next node
            current.next = new ListNode(carry % 10);
            current = current.next;
            // Update carry for the next iteration
            carry /= 10;
        }

        // If carry is not zero, create a new node with the carry value
        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummy.next; // Return the head of the result list (excluding the dummy node)
    }

    // Helper function to print the linked list
    private void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.next + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example usage
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        SumOfTwoLinkedLists solution = new SumOfTwoLinkedLists();
        System.out.println("List 1:");
        solution.printList(l1);
        System.out.println("List 2:");
        solution.printList(l2);

        ListNode sum = solution.addTwoNumbers(l1, l2);

        System.out.println("Sum of the two lists:");
        solution.printList(sum);
    }
}

