package com.dsalgo.graphs;

import com.dsalgo.trees.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    //To store the cloned one we are using an hash map with key as original node and value as the cloned node
    //It is useful when we encounter the same node again then we fetch the cloned node and link it as neighbor
    //we can traverse the graph using DFS or BFS

    private HashMap<Node, Node> nodeHashMap = new HashMap<>();

    public Node cloneGraph(Node node) {

        //Base case
        if (node == null) {
            return null;
        }

        //Checking the node already exists in the map if it exists then return directly and add to the neighbor list
        if (nodeHashMap.containsKey(node)) {
            nodeHashMap.get(node);
        }


        //If it is not yet cloned then create a cloned node
        Node clonedNode = new Node(node.val);
        nodeHashMap.put(node, clonedNode);
        for (Node neighbor : node.neighbors) {
            clonedNode.neighbors.add(cloneGraph(neighbor));
        }

        return clonedNode;

    }

    //Cloned Graph using BFS
    public Node cloneGraphUsingBFS(Node node) {
        if (node == null) {
            return null;  // Base case: if the input node is null, return null.
        }

        // A map to store original node to its corresponding cloned node.
        Map<Node, Node> visited = new HashMap<>();

        // Initialize BFS with a queue.
        Queue<Node> queue = new LinkedList<>();

        // Clone the root node and add it to the queue and map.
        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);
        queue.add(node);

        // Perform BFS traversal.
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            // Traverse through each neighbor of the current node.
            for (Node neighbor : currentNode.neighbors) {
                // If this neighbor hasn't been cloned yet.
                if (!visited.containsKey(neighbor)) {
                    // Clone the neighbor and put it into the map.
                    Node neighborClone = new Node(neighbor.val);
                    visited.put(neighbor, neighborClone);
                    // Add the neighbor to the queue for BFS processing.
                    queue.add(neighbor);
                }

                // Link the clone of the current node to the clone of the neighbor.
                visited.get(currentNode).neighbors.add(visited.get(neighbor));
            }
        }

        // Return the clone of the starting node.
        return cloneNode;
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node2.neighbors.add(node1);
        node2.neighbors.add(node4);
        node3.neighbors.add(node4);
        node3.neighbors.add(node1);
        node4.neighbors.add(node3);
        node4.neighbors.add(node2);
        CloneGraph cloneGraph = new CloneGraph();
        Node clonedGraph = cloneGraph.cloneGraph(node1);

    }
}
