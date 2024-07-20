package com.dsalgo.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphAdjacencyList {

    public int numOfVertices;
    public List<List<Integer>> adjList;

    public GraphAdjacencyList(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        adjList = new ArrayList<>(numOfVertices);
        for (int i = 0; i < numOfVertices; i++) {
            adjList.add(new ArrayList<>());

        }
    }

    public void addEdge(int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void printAdjList() {
        for (int i = 0; i < numOfVertices; i++) {
            for (int v : adjList.get(i)) {
                System.out.println(v + " ");
            }
            System.out.println();
        }
    }


}
