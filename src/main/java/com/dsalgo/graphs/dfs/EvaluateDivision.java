package com.dsalgo.graphs.dfs;

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

        Queue<org.apache.commons.lang3.tuple.Pair<String, Double>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(org.apache.commons.lang3.tuple.Pair.of(u, 1.0));
        visited.add(u);

        while (!queue.isEmpty()) {

            org.apache.commons.lang3.tuple.Pair<String, Double> currentPair = queue.poll();
            String node = currentPair.getKey();
            double product = currentPair.getValue();

            if (node.equals(v)) {
                return product;
            }

            for (Map.Entry<String, Double> entry : graph.get(node).entrySet()) {

                if (!visited.contains(entry.getKey())) {
                    visited.add(entry.getKey());
                    queue.offer(org.apache.commons.lang3.tuple.Pair.of(entry.getKey(), product * entry.getValue()));
                }
            }
        }

        return -1.0;

    }

    public double[] calcEquationUsingDFS(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph
        Map<String, List<Pair>> graph = new HashMap<>();

        // Fill the graph
        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(new Pair(v, val));
            graph.get(v).add(new Pair(u, 1.0 / val));
        }

        // Answer each query
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            if (!graph.containsKey(u) || !graph.containsKey(v)) {
                result[i] = -1.0;
            } else {
                result[i] = dfs(u, v, graph, new HashSet<>(), 1.0);
            }
        }

        return result;
    }

    // Depth First Search to find the path between two nodes and calculate the result
    private double dfs(String u, String v, Map<String, List<Pair>> graph, Set<String> visited, double currentProduct) {
        if (u.equals(v)) return currentProduct;

        visited.add(u);

        for (Pair neighbor : graph.get(u)) {
            if (!visited.contains(neighbor.node)) {
                double result = dfs(neighbor.node, v, graph, visited, currentProduct * neighbor.value);
                if (result != -1.0) return result;
            }
        }

        return -1.0;
    }

    private static class Pair {
        String node;
        double value;
        Pair(String node, double value) {
            this.node = node;
            this.value = value;
        }
    }

}
