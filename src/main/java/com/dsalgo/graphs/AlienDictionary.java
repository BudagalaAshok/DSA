package com.dsalgo.graphs;


import java.util.ArrayList;
import java.util.List;

/**
 * We have an input of list of words and need to find out what was the dictionary order for that based on the list of input words
 * Example 1:
 * Input: N = 5, K = 4
 * dict = {"baa","abcd","abca","cab","cad"}
 * Output: b d a c
 * Explanation:
 * We will analyze every consecutive pair to find out the order of the characters.
 * The pair “baa” and “abcd” suggests ‘b’ appears before ‘a’ in the alien dictionary.
 * The pair “abcd” and “abca” suggests ‘d’ appears before ‘a’ in the alien dictionary.
 * The pair “abca” and “cab” suggests ‘a’ appears before ‘c’ in the alien dictionary.
 * The pair “cab” and “cad” suggests ‘b’ appears before ‘d’ in the alien dictionary.
 * So, [‘b’, ‘d’, ‘a’, ‘c’] is a valid ordering.
 */

public class AlienDictionary {


    /**
     * When is the ordering not possible?
     * There are two such cases when ordering is not possible:
     * If every character matches and the largest word appears before the shortest word: For example, if “abcd” appears before “abc”, we can say the ordering is not possible.
     * If there exists a cyclic dependency between the characters: For example, in the dictionary: dict: {“abc”, “bat”, “ade”} there exists a cyclic dependency between ‘a’ and ‘b’ because the dictionary states ‘a’ < ‘b’ < ‘a’, which is not possible.
     *
     * @param words
     * @param k
     * @return
     * @throws Exception
     */

    public static String findAlienOrder(String[] words, int k) throws Exception {

        //From the given words we need to form a DAG and then apply topological sort and then print the final order
        //How to form an adjacencyList based on the words given,Iterate all the words and compare two words at a time then create adjacencyList
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adjacencyList.add(new ArrayList<>());
        }


        for (int i = 0; i < k - 1; i++) {

            String s1 = words[i];
            String s2 = words[i + 1];

            int minLength = Math.min(s1.length(), s2.length());
            //And then iterate
            for (int j = 0; j < minLength; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    //To get the number from the character
                    adjacencyList.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }

        }

        //Now we have adjacencylist and now apply topological sort
        List<Integer> topoList = PrintTopologicalOrdering.printTSUsingBFS(adjacencyList);
        StringBuilder stringBuilder = new StringBuilder();
        for (int order : topoList) {
            //Now adding 'a' to get the character back
            stringBuilder.append((char) order + (int) ('a'));
        }

        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }


}
