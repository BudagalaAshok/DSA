package com.dsalgo.divideAndConquer;

import com.dsalgo.trees.Node;

import java.util.*;

public class MergeKSortedLists {

    //Using Brute force we have given heads of all the linked list
    //Now using the head we can traverse and add the elements to an list and then finally sort
    //Once sorting was done we can create an linked list using list elements
    //TC: 0(K*N)+O(mlogm)+O(m) here 'm' represents the n*k
    public Node mergeKLists(Node[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        List<Integer> elements = new ArrayList<>();
        for (Node eachNode : lists) {
            Node temp = eachNode;
            while (temp != null) {
                elements.add(temp.val);
                temp = temp.next;
            }
        }

        Collections.sort(elements);
        //Now list in to linkedList
        Node dummy = new Node(0);
        Node current = dummy;
        for (Integer element : elements) {

            Node newNode = new Node(element);
            current.next = newNode;
            current = current.next;
        }
        return dummy.next;
    }

    /**
     * Second solution is inplace merge of two sorted linked list and then find the head and then move to the next head of the given
     * list and then apply the same inplace merge and then so on and then finally return head
     **/

    public Node mergeKSortedListUsingBetterApproach(Node[] lists) {

        //First take the head of the first linked list
        Node head = lists[0];
        for (int i = 1; i < lists.length; i++) {

            head = inPlaceMergeUsingTwoSortedLists(head, lists[i]);
        }

        return head;

    }

    private Node inPlaceMergeUsingTwoSortedLists(Node head1, Node head2) {

        Node dummy = new Node(0);
        Node current = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                current.next = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                head2 = head2.next;
            }
            current = current.next;
        }

        if (head1 != null) {
            current.next = head1;
        }

        if (head2 != null) {
            current.next = head2;
        }

        return dummy.next;

    }


    /**
     * Optimal solution is using PriorityQueue or Heap.
     * Push all the list node head and its value to the heap
     * Once done iterate until priority queue is empty and then take the top element(min element) and then find the next node and its value, push those two values as a pair
     * to the queue before pushing just remove the top element and then finally return the dummy.next
     **/

    public static Node mergeKSortedListsUsingOptimalApproach(List<Node> nodes) {

        //First push the value of head and head to the priority queue
        PriorityQueue<Map.Entry<Integer, Node>> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));
        //Now iterate and insert items into pq
        for (Node node : nodes) {
            priorityQueue.add(new AbstractMap.SimpleEntry<>(node.val, node));
        }

        Node dummy = new Node(0);
        Node current = dummy;
        //Now iterate the priority queue until and unless it is empty
        while (!priorityQueue.isEmpty()) {

            Map.Entry<Integer, Node> entry = priorityQueue.poll();
            if (entry.getValue().next != null) {
                priorityQueue.add(new AbstractMap.SimpleEntry<>(entry.getValue().next.val, entry.getValue().next));
            }

            current.next = entry.getValue();
            current = current.next;

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // Create linked lists
        Node head1 = new Node(2, new Node(4, new Node(6)));
        Node head2 = new Node(1, new Node(5));
        Node head3 = new Node(1, new Node(1, new Node(3, new Node(7))));
        Node head4 = new Node(8);

        // Populate the lists vector
        ArrayList<Node> lists = new ArrayList<>();
        lists.add(head1);
        lists.add(head2);
        lists.add(head3);
        lists.add(head4);

        System.out.println("Original Linked Lists:");
        for (int i = 0; i < lists.size(); ++i) {
            System.out.print("List " + (i + 1) + ": ");
            printLinkedList(lists.get(i));
        }

        // Merge the linked lists
        Node mergedList = mergeKSortedListsUsingOptimalApproach(lists);

        // Print the merged linked list
        System.out.print("Merged Linked List: ");
        printLinkedList(mergedList);
    }

    private static void printLinkedList(Node head) {

        Node temp = head;
        while (temp != null) {
            // Print the data of the current node
            System.out.print(temp.val + " ");
            // Move to the next node
            temp = temp.next;
        }
        System.out.println();
    }
}

