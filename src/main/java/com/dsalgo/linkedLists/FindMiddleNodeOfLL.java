package com.dsalgo.linkedLists;

public class FindMiddleNodeOfLL {

    //Using Brute force approach, Here we are iterating the entire linked list one and half times one is full and another one is half iteration
    //First find the size and then find the middle mid/2 +1 and then iterate and find the middle

    //Instead of doing that we can use slow and fast pointer technique
    //Slow pointer moves one step at a time and fast pointer moves two steps at a time


    //using this approach we can find the middle node using n/2 iterations
    Node findMiddleOfLL(Node head){

        Node slow=head;
        Node fast=head;

        //This work for both even and size of linked list
        while(fast!=null && fast.next!=null && slow!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;

    }

}
