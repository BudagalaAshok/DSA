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


}
