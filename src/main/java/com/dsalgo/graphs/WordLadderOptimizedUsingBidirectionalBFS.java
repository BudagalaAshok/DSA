package com.dsalgo.graphs;

import com.dsalgo.graphs.bfs.WordLadder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadderOptimizedUsingBidirectionalBFS {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);  // Convert list to set for O(1) lookups
            if (!wordSet.contains(endWord)) return 0;  // Early exit if endWord is not in the list

            // Bidirectional BFS initialization
            Set<String> beginSet = new HashSet<>();
            Set<String> endSet = new HashSet<>();
            Set<String> visited = new HashSet<>();

            beginSet.add(beginWord);
            endSet.add(endWord);
            int level = 1;

            while (!beginSet.isEmpty() && !endSet.isEmpty()) {
                // Always expand the smaller set to improve efficiency
                if (beginSet.size() > endSet.size()) {
                    Set<String> temp = beginSet;
                    beginSet = endSet;
                    endSet = temp;
                }

                Set<String> nextLevel = new HashSet<>();
                for (String word : beginSet) {
                    char[] wordArray = word.toCharArray();

                    for (int i = 0; i < wordArray.length; i++) {
                        char originalChar = wordArray[i];

                        // Try all 26 possible characters in the current position
                        for (char c = 'a'; c <= 'z'; c++) {
                            wordArray[i] = c;
                            String newWord = new String(wordArray);

                            // If we meet the other set, return the current level + 1
                            if (endSet.contains(newWord)) {
                                return level + 1;
                            }

                            // If the new word is in the word set and hasn't been visited, add to next level
                            if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                                visited.add(newWord);
                                nextLevel.add(newWord);
                            }
                        }
                        wordArray[i] = originalChar;  // Restore the original word
                    }
                }

                beginSet = nextLevel;
                level++;
            }

            return 0;  // No path found
        }

        public static void main(String[] args) {
            WordLadder wl = new WordLadder();
            List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
            System.out.println(wl.ladderLength("hit", "cog", wordList));  // Output: 5
        }

}
