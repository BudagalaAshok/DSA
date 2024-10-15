package com.dsalgo.graphs.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Approach 1: Topological Sorting (Kahn’s Algorithm)
 *
 * Algorithm:
 *
 * 	1.	Create an adjacency list to represent the graph.
 * 	2.	Create an array inDegree[] to store the number of prerequisites for each course.
 * 	3.	Initialize a queue with all courses that have zero prerequisites.
 * 	4.	Perform BFS:
 * 	•	Pop a course from the queue, process it (add it to the result), and decrease the in-degree of its neighbors.
 * 	•	If any neighbor’s in-degree becomes zero, add it to the queue.
 * 	5.	If all courses are processed, return true (no cycle). If any course is left unprocessed, return false (cycle detected).
 */


public class CourseScheduleI {

    public boolean isFinishAllCourses(int courses, int[][] prequisites){

        //Build the graph and indegree array
        List<List<Integer>> graph=new ArrayList<>();
        int[] indegree=new int[courses];
        for (int i = 0; i < indegree.length; i++) {
            graph.add(new ArrayList<>());
        }

        //By using preq 2d array we build the graph because there was an directed edge between preq and course
        for(int[] prequisite: prequisites){
            int course=prequisite[0];
            int preq=prequisite[1];
            graph.get(preq).add(course);
            indegree[course]++;
        }

        //Add courses with in-degree 0 to the queue
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < graph.size(); i++) {
            if(indegree[i]==0){
                queue.offer(i);
            }
        }

        int coursesTaken=0;
        while (!queue.isEmpty()){
            int node=queue.poll();
            coursesTaken++;
            //For each course that depends up on the current course
            for (int neighbor:graph.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    queue.add(neighbor); //If no more preq add to queue
                }
            }
        }

        //Check if all courses were taken
        return coursesTaken==graph.size();

    }

}
