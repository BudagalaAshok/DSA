package com.dsalgo.linkedLists;

import java.util.HashSet;
import java.util.Set;

public class IntersectionPointOfTwoLL {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        Set<ListNode> nodeSet=new HashSet<>();
         /*Stack<ListNode> stackA=new Stack<>();
         Stack<ListNode> stackB=new Stack<>();*/

        ListNode currentA=headA;
        while(currentA!=null){
            nodeSet.add(currentA);
            currentA=currentA.next;
        }

        ListNode currentB=headB;
        /* while(currentB!=null){
            stackB.push(currentB);
            currentB=currentB.next;
         }*/


        while(currentB!=null && !nodeSet.contains(currentB)){
            currentB=currentB.next;
        }

        return currentB;


    }

}
