package com.dsalgo.linkedLists;

public class CloneListWithRandomPointer {

    //First solution using hashmap we can do that 0(n) and space complexity is o(n)
    //To do this just copy the original node and copy of the original node first in to the hashmap
    //Next step is iterate the linked list and connect the random pointers by using hashamp original node to copied node random pointer
    //Then return map.get(head)

    //Second solution is using with out using extra space

    public DummyNode cloneCopiedRandomList(DummyNode head){

        //Step 1 insert the copied nodes between the individual nodes
        DummyNode temp=head;
        while (temp!=null){
            DummyNode newNode=new DummyNode(temp.val);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=temp.next.next;
        }

        //Step 2 connect random pointers of the copied nodes
        temp=head;
        while (temp!=null){
            DummyNode copiedNode=temp.next;
            if(temp.random!=null) {
                copiedNode.random = temp.random.next;
            }else{
                copiedNode.random=null;
            }
            temp=temp.next.next;
        }

        //Step 3 Now connect next nodes to the copied nodes
        DummyNode dummyNode=new DummyNode(-1);
        DummyNode res=dummyNode;
        temp=head;
        while (temp!=null){
            res.next=temp.next;
            temp.next=temp.next.next;
            res=res.next;
            temp=temp.next;
        }
        return dummyNode.next;

    }

    /**
     * Solution Overview
     *
     * We’re going to use three simple steps to do this:
     *
     * 	1.	Create duplicate toys and place them next to each original toy.
     * 	2.	Copy the random pointers from each original toy to its duplicate.
     * 	3.	Separate the original toys from the duplicates so that the copies form their own list.
     *
     * Let’s go through each step like we’re connecting real toys.
     */

    public ListNode copiedWithRandomNode(ListNode root){

        //Ste1 place the duplicate node beside the original node

        ListNode current=root;
        while (current!=null){
            ListNode copy=new ListNode(current.val);
            copy.next=current.next;
            current.next=copy;
            current=copy.next;
        }
        //Step2 Now copy the random pointers for duplicate nodes as same as the original nodes
        current=root;
        while (current!=null){

            if(current.random!=null){
                current.next.random=current.random.next;
            }

            current=current.next.next;

        }

        //Step3 : Now seperate both original and copied nodes in an seperate line and return the copiedNode
        current=root;
        ListNode copiedHead=current.next;
        ListNode copy=copiedHead;
        while (current!=null){

            current.next=current.next.next;

            if(copy.next!=null){
                copy.next=copy.next.next;
            }

            current=current.next;
            copy=copy.next;
        }
        return copiedHead;
    }

}
