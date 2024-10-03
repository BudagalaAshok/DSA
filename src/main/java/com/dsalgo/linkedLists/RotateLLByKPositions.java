package com.dsalgo.linkedLists;

public class RotateLLByKPositions {

    public ListNode rotateRight(ListNode head, int k) {

        if(head==null || head.next==null || k==0){
            return head;
        }
        int length=1;

        //Find the length of the linked list
        ListNode temp=head;
        while(temp.next!=null){
            length++;
            temp=temp.next;
        }

        //If the calculated k value is 0 the directly return the head no need to do anything
        k=k%length;
        if(k==0){
            return head;
        }

        //Make it circular and point the last node back to the head
        temp.next=head;
        int iteratePosition=length-k;

        //Now move the currentNode to the iterate position length
        ListNode currentNode=head;
        for(int i=1;i<iteratePosition;i++){
            currentNode=currentNode.next;
        }

         //After that store the tailNode by using currentNode and after that mark the currentNode.next as null by breaking the link
        ListNode tailNode=currentNode.next;
        currentNode.next=null;
        //Finally return the tailNode
        return tailNode;
    }
}
