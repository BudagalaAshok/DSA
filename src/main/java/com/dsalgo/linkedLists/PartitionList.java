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

    /**
     * Intuition Behind the Solution
     * <p>
     * Think of the list as being split into two sections:
     * <p>
     * 1.	Left Section: Contains nodes with values less than x.
     * 2.	Right Section: Contains nodes with values greater than or equal to x.
     * <p>
     * The goal is to iterate through the list and partition the nodes into these two sections, then connect the two sections to get the final reordered list. This approach ensures we don’t need extra space beyond a few pointers and that the nodes remain in their original order within each section.
     * <p>
     * Approach and Steps to Remember
     * <p>
     * Here’s a simplified step-by-step breakdown of the solution:
     * <p>
     * 1.	Initialize Two Dummy Nodes:
     * •	Use two dummy nodes, leftDummy and rightDummy, to start the two partitions.
     * •	leftDummy will point to nodes with values less than x, and rightDummy to nodes with values greater than or equal to x.
     * •	These dummy nodes simplify edge cases and help in building each partition separately.
     * 2.	Partition the List:
     * •	Traverse through the list. For each node:
     * •	If the node’s value is less than x, append it to the left partition.
     * •	Otherwise, append it to the right partition.
     * •	Move the respective pointers (left and right) as you add nodes.
     * 3.	Connect the Two Partitions:
     * •	After the traversal, link the last node of the left partition (left.next) to the start of the right partition (rightDummy.next).
     * •	Set the last node of the right partition (right.next) to null to ensure the end of the list.
     * 4.	Return the New Head:
     * •	The head of the new list will be the node after leftDummy, so return leftDummy.next.
     *
     * @param head
     * @param x
     * @return
     */

    /**
     * Time Complexity
     *
     * 	•	 O(n) : We need to traverse the entire list once to reorder the nodes. Since we go through each node exactly once,
     * 	the time complexity is linear in terms of the number of nodes,  n .
     *
     * Space Complexity
     *
     * 	•	 O(1)  (if we are not using any additional data structures): We’re simply rearranging pointers, not creating any extra lists or arrays,
     * 	so the space complexity is constant.
     */

    public ListNode partitionLL(ListNode head, int x) {
        // Create two left nodes to start the less and greater lists
        ListNode temp = head;
        ListNode leftDummy = new ListNode(-1);
        ListNode left = leftDummy;
        ListNode rightDummy = new ListNode(-1);
        ListNode right = rightDummy;
        //Traverse the original list
        while (temp != null) {
            if (temp.val < x) {
                left.next =temp;
                left = left.next;
            } else {
                right.next = temp;
                right = right.next;
            }
            temp = temp.next;
        }
        //Connect the first and second list
        left.next = rightDummy.next;
        //Point second list next to null
        right.next = null;
        //return the new head which is the start of first list
        return leftDummy.next;
    }
}
