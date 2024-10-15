package com.dsalgo.graphs.bfs;

import java.util.*;

//BFS Problem
public class WordLadder {


    //Using BFS to traverse level by level and checking all the combinations for each word in the list
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int count = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                String currentWord = queue.poll();
                char[] currentCharArray = currentWord.toCharArray();
                for (int j = 0; j < currentCharArray.length; j++) {
                    char originalChar = currentCharArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        currentCharArray[j] = c;
                        String requiredString = new String(currentCharArray);

                        if (requiredString.equals(endWord)) {
                            return count + 1;
                        }

                        if (!visited.contains(requiredString) && wordSet.contains(requiredString)) {
                            visited.add(requiredString);
                            queue.add(requiredString);
                        }


                    }

                    currentCharArray[j] = originalChar;

                }


            }
            count++;

        }

        return 0;
    }
}
