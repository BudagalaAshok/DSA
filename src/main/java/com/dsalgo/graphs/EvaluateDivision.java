package com.dsalgo.graphs;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double value = values[i];
            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, value);
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0 / value);
        }

        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {

            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            if (!graph.containsKey(u) || !graph.containsKey(v)) {
                results[i] = -1.0;
            } else if (u.equals(v)) {
                results[i] = 1.0;
            } else {
                results[i] = bfs(graph, u, v);
            }

        }

        return results;

    }

    public double bfs(Map<String, Map<String, Double>> graph, String u, String v) {

        Queue<Pair<String, Double>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(Pair.of(u, 1.0));
        visited.add(u);

        while (!queue.isEmpty()) {

            Pair<String, Double> currentPair = queue.poll();
            String node = currentPair.getKey();
            double product = currentPair.getValue();

            if (node.equals(v)) {
                return product;
            }

            for (Map.Entry<String, Double> entry : graph.get(node).entrySet()) {

                if (!visited.contains(entry.getKey())) {
                    visited.add(entry.getKey());
                    queue.offer(Pair.of(entry.getKey(), product * entry.getValue()));
                }
            }
        }

        return -1.0;

    }

}
