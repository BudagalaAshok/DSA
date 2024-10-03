package com.dsalgo.linkedLists;

public class SumOfTwoLL {

    public DummyNode sumOfLL(DummyNode l1, DummyNode l2){

        DummyNode dummy=new DummyNode(0);
        DummyNode current=dummy;
        int carry=0;
        while (l1!=null || l2!=null){
            if(l1!=null){
                carry+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                carry+=l2.val;
                l2=l2.next;
            }
            current.next =new DummyNode(carry%10);
            current=current.next;
            carry/=10;
        }
        if(carry>0){
            current.next =new DummyNode(carry);
        }
        //Because dummy node pointing to zero
        return dummy.next;
    }

    public DummyNode mergeTwoLists(DummyNode list1, DummyNode list2) {

        DummyNode dummy=new DummyNode(0);
        DummyNode current=dummy;
        while(list1!=null & list2!=null){

            if(list1.val<=list2.val){
                current.next =list1;
                list1=list1.next;
            }else{
                current.next=list2;
                list2=list2.next;
            }
            current=current.next;
        }
        if(list1!=null){
            current.next=list1;
        }else {
            current.next=list2;
        }

        return dummy.next;

    }

}

class DummyNode {

    int val;
    DummyNode next;
    DummyNode random;
    public DummyNode(int val){
        this.val=val;
    }

}
