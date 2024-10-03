package com.dsalgo.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 	•	“Zero prerequisites first”: Start with tasks that have no dependencies.
 * 	•	“Reduce dependencies”: As you finish a task, unlock its dependents by reducing their dependency count.
 * 	•	“Detect cycles”: If you can’t finish all tasks, you’ve found a cycle.
 */
public class CourseScheduleII {

    /**
     * It is same as course scheduleI problem but here we are adding the order of courses which we need to finish incase if there is no cycle
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] preq : prerequisites) {

            int course = preq[0];
            int prequisite = preq[1];
            graph.get(prequisite).add(course);
            inDegree[course]++;
        }

        //First adding all the courses having indegree is Zero
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        List<Integer> topoSort = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            topoSort.add(course);

            for (int neighbor : graph.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }

        }

        if (topoSort.size() == numCourses) {
            int[] result = new int[numCourses];
            for (int i = 0; i < topoSort.size(); i++) {
                result[i] = topoSort.get(i);
            }
            return result;
        }

        return new int[0];

    }
}
