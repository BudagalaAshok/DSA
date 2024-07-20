package com.dsalgo.graphs;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/**
 * There was a problem to complete the jobs in the given order if we are able to complete then return true otherwise false. It should be solved using
 * topological soring
 * Another problem is to just reverse u should be complete after v there also we use same solution while creating the graph we reverse the u and v nodes
 */
public class PrintTopologicalOrdering {

    //If there are two nodes u,v and u should be appear before v that was the order we need to find, If there are so many we need to find one and print
    //To find this graph is directed asycyclic graph and it shouldn't contain any cycles
    //Here we used stack to do this
    public void printTopologicalSortUsingDFS(List<List<Integer>> adjacencyList) {

        boolean[] visited = new boolean[adjacencyList.size()];
        Stack<Integer> stack = new Stack<>();
        //Zero based node indexing
        for (int i = 0; i < adjacencyList.size(); i++) {

            if (!visited[i]) {
                //Call DFS to find out that
                dfs(adjacencyList, i, visited, stack);
            }

        }

        //Now print the stack elements
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + "\t");
        }
        System.out.println();
    }

    private void dfs(List<List<Integer>> adjacencyList, int node, boolean[] visited, Stack<Integer> stack) {

        visited[node] = true;
        for (int adjacencyNode : adjacencyList.get(node)) {

            if (!visited[adjacencyNode]) {
                //Again call dfs until all calls were made and nothing was left
                dfs(adjacencyList, adjacencyNode, visited, stack);
            }
        }

        stack.push(node);

    }


    //Here we use queue to find this
    //Kahn's algorithm works by iteratively processing vertices with no incoming edges (in-degree 0), ensuring that each vertex is only processed
    // once all its dependencies have been resolved.
    // This approach guarantees a valid topological order for DAGs and efficiently detects cycles, making it a robust method for topological sorting
    public static List<Integer> printTSUsingBFS(List<List<Integer>> adjacencyList) throws Exception {

        //First step is to find the indegree of each node that means how many edges are coming in to that node
        int[] indegree = new int[adjacencyList.size()];
        for (int i = 0; i < adjacencyList.size(); i++) {
            for (int adjacencyNode : adjacencyList.get(i)) {
                indegree[adjacencyNode]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        //Now push to queue where in-degree is zero,this means these vertices don't have any dependencies so we can process them immediately
        //So we can place them as first in our topological ordering

        for (int i = 0; i < adjacencyList.size(); i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> topoList = Lists.newLinkedList();
        int count = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();
            topoList.add(node);
            for (int neighbor : adjacencyList.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }

            }
            count++;

        }

        if (count != adjacencyList.size()) {
            //Graph as cycles so not possible of topological sorting
            throw new Exception("Topological order is not possible because graph contain cycles");
        }

        //Otherwise print order
        System.out.println(topoList);
        return topoList;

    }


}
