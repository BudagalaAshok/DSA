package com.dsalgo.graphs;

import org.apache.commons.lang3.tuple.Pair;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheckTree {

    //A graph we call it as a tree means it should satisfy below two conditions
    // It does not contains cycle
    // And graph should be connected that means a paths should exists from source to destination

    //Using BFS
    //Initially we don't have parent and we can pass it as -1;
    public boolean isCycle(int node, List<List<Integer>> adjacencyList, boolean[] visited, int parent) {

        //For BFS we use queue data structure
        visited[node] = true;
        Pair<Integer, Integer> pair = Pair.of(node, parent);
        Queue<Pair<Integer, Integer>> queue = new PriorityQueue<>();
        queue.add(pair);
        while (!queue.isEmpty()) {

            int currentElement = queue.poll().getKey();
            int nodeParent = queue.poll().getValue();

            for (int adjacentElement : adjacencyList.get(currentElement)) {

                if (!visited[adjacentElement]) {
                    queue.add(Pair.of(adjacentElement, currentElement));
                    visited[adjacentElement] = true;
                }
                //If a visited node is found that is not the parent of the current node, it indicates a cycle.
                else if (adjacentElement != nodeParent) {
                    return true;
                }

            }

        }

        return false;

    }

    public boolean isTree(List<List<Integer>> adjacencyList) {
        boolean[] visited = new boolean[adjacencyList.size()];
        //Zero based node index
        if (isCycle(0, adjacencyList, visited, -1)) {
            return false;
        }

        //if all the nodes are visited then it is connected otherwise not

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;

    }


    //Here we use recursion and no need of queue here

    public boolean isCycleUsingDFS(int node, List<List<Integer>> adjacencyList, boolean[] visited, int parent) {
        //For BFS we use queue data structure
        visited[node] = true;
        for (int adjacencyNode : adjacencyList.get(node)) {
            if (!visited[adjacencyNode]) {
               if(isCycleUsingDFS(adjacencyNode, adjacencyList, visited, node))
                   return true;
            } else if (adjacencyNode != parent) {
                return true; //Found a cycle based on this condition if the current element is not equal to the parent in-case if it is already visited
            }
        }
        return false;
    }

    public boolean isTreeUsingDFS(List<List<Integer>> adjacencyList) {
        boolean[] visited = new boolean[adjacencyList.size()];
        //Zero based node index
        if (isCycleUsingDFS(0, adjacencyList, visited, -1)) {
            return false;
        }

        //if all the nodes are visited then it is connected otherwise not

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;

    }


}
