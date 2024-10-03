package com.dsalgo.graphs;

import java.util.*;


/**
 * Intuition: Treat each gene as a node and valid mutations as edges in a graph, then use BFS to find the shortest path (minimum mutations)
 * from start to end by exploring all possible one-character mutations level by level.
 *
 * Solution Approach: Use BFS to generate all possible mutations, checking valid ones against the gene bank,
 * and restore original characters after each trial to ensure clean, independent mutations.
 */
public class MinGeneticMutation {

    //Here we use BFS we need to find the shortest path from source to destination
    //why we use BFS means we are traversing level by level here so we can find the target in minimum no of moves
    public int minMutation(String start, String end, String[] bank) {

        //First convert bank array in to set so that it is easy to check if the mutation string is valid or not
        Set<String> mutationBank = new HashSet<>(Arrays.asList(bank));

        //If end gene is not found in bank then return directly from here
        if (!mutationBank.contains(end)) {
            return -1;
        }

        Set<String> visited = new HashSet<>();
        visited.add(start);

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        char[] genes = {'A', 'C', 'G', 'T'};

        int mutations = 0;
        while (!queue.isEmpty()) {

            //Process level by level
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                String current = queue.poll();

                //Check current is equal to the target
                if (current.equals(end)) {
                    return mutations;
                }

                char[] originalString = current.toCharArray();

                //Try mutating each character in the current gene
                for (int j = 0; j < originalString.length; j++) {

                    char currentChar = originalString[j];

                    //Try all possible mutations
                    for (char ch : genes) {
                        if (ch == currentChar)
                            continue;
                        originalString[j] = ch;
                        String currentMutationString = new String(originalString);
                        if (!visited.contains(currentMutationString) && mutationBank.contains(currentMutationString)) {
                            visited.add(currentMutationString);
                            queue.add(currentMutationString);
                        }
                    }

                    //now replace the original character after the mutation trail
                    /*
                       Restoring the original character ensures each mutation is tried fairly and independently.
	                   Without restoring, subsequent mutations would be based on the wrong gene sequence (one that’s already been mutated),
	                    leading to incorrect results.
                     */
                    originalString[j] = currentChar;


                }

            }
            mutations++;
        }
        return -1;

    }
}
