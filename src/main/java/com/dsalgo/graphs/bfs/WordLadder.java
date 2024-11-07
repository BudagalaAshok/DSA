package com.dsalgo.graphs.bfs;

import java.util.*;

//BFS Problem

/**
 * First check the endword is part of the wordList if not found directly return -1
 * Next define visited data-structure to keep track of already visited words to avoid revisiting now push the start word to the queue and start BFS
 * Now convert that String in to char array and iterate up to each character and try with all 26 letters for that position and keep on checking formed string is equal to end of word
 * If not then check that word is part of wordlist then added to visited ds and to queue once done remove the character set from the original string
 * If not found -1;
 */
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
                    //Once all combinations are done just put the original character as it-is in the original string
                    currentCharArray[j] = originalChar;

                }


            }
            count++;

        }

        return 0;
    }
}
