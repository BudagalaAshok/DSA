package com.dsalgo.graphs;

import java.util.List;

public class FindPathUsingDFS {


    //First start with source and then go to neighbour and them from that neighbour explore their neighbours and then so on
    boolean isPathExistsUsingDFS(int source,int dest,List<List<Integer>> adjList,boolean[] visited){

        if(source==dest){
            return true;

        }
        visited[source]=true;
        for(int neighbor:adjList.get(source)){

            if(!visited[neighbor] && isPathExistsUsingDFS(neighbor,dest,adjList,visited)){
                return true;
            }

        }


        return false;

    }

}
