package com.dsalgo.graphs;

import java.util.*;

public class ShortestPathBetweenNodes {

    /**
     * If there is an unique path exists between source and destination then it is the shortest path between two nodes
     * Below solution was implemented using BFS
     * @param source
     * @param destination
     * @param adjacencyList
     * @return
     */

    public static int findShortestPathBetweenTwoNodes(int source, int destination, List<List<Integer>> adjacencyList) {

        //if source and destination are same then return 0;
        if (source == destination) {
            return 0;
        }

        boolean[] visited = new boolean[adjacencyList.size()];
        //Mark source node as true and push to the queue
        visited[source] = true;
        Map<Integer, Integer> map = new HashMap<>();
        //Initially the distance is zero
        map.put(source, 0);
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : adjacencyList.get(currentNode)) {
                if (!visited[neighbor]) {
                    //If we found unique neighbor then we increment the count from parent node to neighbors
                    map.put(neighbor, map.getOrDefault(currentNode, 0)+1);
                    visited[neighbor] = true;
                    if (neighbor == destination) {
                        return map.get(destination);//Destination node found
                    }
                    queue.add(neighbor);
                }

            }
        }

        //If destination node not found then return -1
        return -1;


    }

}
