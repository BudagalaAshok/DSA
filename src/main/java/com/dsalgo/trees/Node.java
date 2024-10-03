package com.dsalgo.trees;

import java.util.ArrayList;
import java.util.List;

public class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;
    public List<Node> neighbors;

    public Node(int val) {
        this.val = val;
        this.neighbors=new ArrayList<>();
    }

    // Constructor with both data and
    // next node as parameters
    public Node(int val, Node next1) {
        this.val = val;
        this.next = next1;
    }


}
