package com.dsalgo.linkedLists;


//TC: O(N) (Dividing groups and reversing) + O(N) (Finding the kth-node)
//SC: O(1)

/**
 * Step1 : First Find the Kth-node and then store the next node of kth node and disconnect the link between kthnode and next node
 * Step2 : now reverse the entire group and put the head in proper place and then link to the next proper node
 * Step3: Check if kth node is null and then link the prevNode to the next node by checking prevNode!=null
 */
public class ReverseNodesInKGroup {

    public ListNode reverseNodesInKGroup(ListNode head,int k){
        ListNode temp=head;
        ListNode prevNode=null;
        while(temp!=null){
            //Find the Kth node with temp and k
            ListNode kthNode=findKthNode(temp,k);
            if(kthNode==null){
                if(prevNode!=null){
                    prevNode.next=temp;
                }
                break;
            }
            //Storing the next node after the kthnode to attach after
            ListNode nextNode=kthNode.next;
            //Now form the seperate linked list by putting next=null
            kthNode.next=null;
            //Now call the reverse method 
            reverseLL(temp);
            //this is the first group whenever temp==head
            if(temp==head){
                head=kthNode;
            }else{
                prevNode.next=kthNode;
            }
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }

    private ListNode reverseLL(ListNode head) {
        // Initialize'temp' at
        // head of linked list
        ListNode temp = head;

        // Initialize pointer 'prev' to NULL,
        // representing the previous node
        ListNode prev = null;

        // Traverse the list, continue till
        // 'temp' reaches the end (NULL)
        while(temp != null){
            // Store the next node in
            // 'front' to preserve the reference
            ListNode front = temp.next;

            // Reverse the direction of the
            // current node's 'next' pointer
            // to point to 'prev'
            temp.next = prev;

            // Move 'prev' to the current
            // node for the next iteration
            prev = temp;

            // Move 'temp' to the 'front' node
            // advancing the traversal
            temp = front;
        }

        // Return the new head of
        // the reversed linked list
        return prev;
    }

    private ListNode findKthNode(ListNode temp, int k) {

        // Decrement K as we already
        // start from the 1st node
        k -= 1;

        // Decrement K until it reaches
        // the desired position
        while (temp != null && k > 0) {
            // Decrement k as temp progresses
            k--;

            // Move to the next node
            temp = temp.next;
        }

        // Return the Kth node
        return temp;
    }
}
