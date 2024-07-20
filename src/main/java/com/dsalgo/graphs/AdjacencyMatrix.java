package com.dsalgo.graphs;

public class AdjacencyMatrix {

    int numOfVertices;
    int[][] graph;

    public AdjacencyMatrix(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        this.graph = new int[numOfVertices][numOfVertices];
    }

    public void addEdge(int i, int j) {
        graph[i][j] = 1;
        graph[j][i] = 1;
    }

    public void removeEdge(int i, int j) {
        graph[i][j] = 0;
        graph[j][i] = 0;
    }

    public void printMatrix() {
        for (int i = 0; i < numOfVertices; i++) {
            for (int j = 0; j < numOfVertices; j++) {
                System.out.println(graph[i][j]);
            }
        }
        System.out.println();
    }


}
