package com.dsalgo.graphs;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindPathUsingBFS {


    public boolean isPathExists(int source, int destination, List<List<Integer>> adjList) {

        if(source==destination){
            return true;
        }

        boolean[] visited=new boolean[adjList.size()];
        Queue<Integer> queue=new PriorityQueue<>();
        queue.add(source);
        visited[source]=true;
        while(!queue.isEmpty()){

            int neighbors=queue.poll();

            for(int neighbor:adjList.get(neighbors)){
                if(!visited[neighbor]){
                    if(neighbor==destination){
                        return true;
                    }
                    visited[neighbor]=true;
                    queue.add(neighbor);
                }
            }

        }

        return false;


    }


}
