package com.dsalgo.linkedLists;

import java.util.HashMap;

public class ImplementBrowserHistory {

    Node current;

    public ImplementBrowserHistory(String url){
        current=new Node(url);
    }

    public Node visit(String url){
        Node newNode= new Node(url);
        current.next=newNode;
        newNode.prev=current;
        current=current.next;
        return current;
    }

    public String back(int steps){

        while(steps>0){

            if(current.prev!=null){
                current=current.prev;
            }else{
                break;
            }
            steps--;
        }
        return current.url;

    }

    public String forward(int steps){

        while(steps>0){

            if(current.next!=null){
                current=current.next;
            }else{
                break;
            }
            steps--;
        }
        return current.url;

    }




}

class Node{
    String url;
    Node prev;
    Node next;

    public Node(String url) {
        this.url = url;
        this.next=null;
        this.prev=null;
    }
}
