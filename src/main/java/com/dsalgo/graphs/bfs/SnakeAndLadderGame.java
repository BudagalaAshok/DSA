package com.dsalgo.graphs.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadderGame {

    public int snakesAndLadders(int[][] board) {

        int n = board.length;
        //We used this 1D array to convert board in to this. Because it is easy we move to any position based on the ladder or snake
        //If it is an 1 D array
        int[] moves = new int[n * n + 1];
        Arrays.fill(moves,-1);
        int index = 1;
        boolean leftToRight = true;//Coming from bottom of the grid
        for (int i = n - 1; i >= 0; i--) {

            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    moves[index++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    moves[index++] = board[i][j];
                }
            }

            //Changing the direction from left to right to right-left alternatively
            leftToRight=!leftToRight;

        }

        //Use BFS to traverse level by level to find min moves required to reach destination
        //Here we are using the array to store the current position in the board and also the count the number of moves
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 1});

        //we use an visited array to check if that node is already visited or not
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;
        while (!queue.isEmpty()) {

            int[] currentNode = queue.poll();
            int currentPosition = currentNode[0];
            int movesCount = currentNode[1];

            //If we move the destination then we can return
            if (currentPosition == n * n) {
                return movesCount;
            }

            //Otherwise we need to roll a dice of 1 to 6
            for (int i = 1; i <= 6 && i + currentPosition <= n * n; i++) {

                int nextMove=currentPosition+i;

                //Then it is a snake or ladder
                if(moves[nextMove]!=-1){
                    nextMove=moves[nextMove];
                }
                //If it is not visited, then add to the queue
                if(!visited[nextMove]){
                    visited[nextMove]=true;
                    queue.add(new int[]{nextMove,movesCount+1});
                }

            }

        }

        //no solution found return -1
        return -1;


    }

}
