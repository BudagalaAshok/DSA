package com.dsalgo.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
