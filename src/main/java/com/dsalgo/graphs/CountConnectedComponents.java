package com.dsalgo.graphs;

import java.util.List;

public class CountConnectedComponents {


    //Each component we call it as subgraph. A graph contains multiple components
    public int countNoOfComponents(List<List<Integer>> adjacencyList) {
        boolean[] visited = new boolean[adjacencyList.size()];
        //Zero based node graph
        int count = 0;
        for (int i = 0; i < adjacencyList.size(); i++) {

            if (!visited[i]) {
                //Call DFS or BFS here to traverse the graph
                dfs(i, adjacencyList, visited);
            }
            count++;

        }
        return count;
    }

    /**
     * It will traverse the graph from source to destination that means it an a component and we go to the another component
     *
     * @param node
     * @param adjacencyList
     * @param visited
     */

    private void dfs(int node, List<List<Integer>> adjacencyList, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adjacencyList.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adjacencyList, visited);
            }
        }
    }


}
