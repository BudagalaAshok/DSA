package com.dsalgo.graphs;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands {

    public static int countNoOfDistinctIslands(int[][] matrix, int n, int m) {

        //Visited array of size n*m
        boolean[][] visited = new boolean[n][m];
        Set<List<Pair<Integer,Integer>>> distinctIslands = new HashSet<>();
        //now for each cell we will traverse and find the connected cells where we have water
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (!visited[i][j]) {
                    //Call DFS here
                    List<Pair<Integer, Integer>> pairs = Lists.newArrayList();
                    dfs(i, j, matrix, visited, pairs, i, j);
                    distinctIslands.add(pairs);
                }

            }

        }

        return distinctIslands.size();
    }

    private static void dfs(int row, int col, int[][] matrix, boolean[][] visited,
                            List<Pair<Integer, Integer>> pairs, int baseRow, int baseCol) {

        visited[row][col] = true;
        pairs.add(Pair.of((row - baseRow), (col - baseCol)));

        //We can go to four directions form i,j then deltaRow and deltaCol will be
        int n=matrix.length;
        int m=matrix[0].length;
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, 1};

        //Because we can go up to 4 directions,for each direction make an dfs to visit that node
        for (int i=0;i<4;i++){

            int nRow=deltaRow[i]+i;
            int nCol=deltaCol[i]+i;
            //It is not visited and it has water
            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !visited[nRow][nCol] && matrix[nRow][col]==1){
                dfs(nRow,nCol,matrix,visited,pairs,baseRow,baseCol);
            }

        }

    }


}
