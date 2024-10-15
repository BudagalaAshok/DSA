package com.dsalgo.greedy;

import java.util.LinkedList;

public class PoliceManAndTheif {

    /**
     * Here we are using two for loops one to search for police and then after that we use another for loop to search from police position
     * From police position we need to search either left or right and the condition for left and right range should be less than k
     * If police found a theif then we can break the second loop and continue
     * TC: O(n*k) --> for each police we are checking k positions
     * @param input
     * @param k
     * @return
     */
    public int findMaxTheifUsingBruteForce(char[] input, int k) {

        //Maintaining a visited array to keep track of catched theifs
        boolean[] visited = new boolean[input.length];
        int totalTheifCount = 0;

        for (int i = 0; i < input.length; i++) {

            //Search for the police
            if (input[i] == 'P') {

                //	•	Left bound: Math.max(0, i - k) ensures that the search for thieves doesn’t go beyond the starting position of the array.
                //	•	Right bound: Math.min(n - 1, i + k) ensures that the search for thieves doesn’t exceed the end of the array.
                for (int j = Math.min(0, i - k); j < Math.max(input.length - 1, i + k); j++) {

                    if (input[j] == 'T' && !visited[j]) {
                        totalTheifCount++;
                        break;
                    }

                }

            }

        }

        return totalTheifCount;

    }

    //Optimal Solution using two pointers
    //First we will store all the police man position into an list and theif position in to an another list
    //Now we maintain two pointers pointing to theif and police if difference both of them is less than or equal to k then increment
    //If theif is to far from left of the policeman then increment theif
    //If the police is to from the left of the police man then increment police

    /**
     * TC: O(n)
     * @param input
     * @param k
     * @return
     */
    public static int findMaxTheif(char[] input, int k) {

        LinkedList<Integer> polices = new LinkedList<>();
        LinkedList<Integer> theifs = new LinkedList<>();

        for (int i = 0; i < input.length - 1; i++) {
            if (input[i] == 'P') {
                polices.add(i);
            }
            if (input[i] == 'T') {
                theifs.add(i);
            }

        }

        int theifsCount = 0;
        while (!polices.isEmpty() && !theifs.isEmpty()) {
            int policePosition = polices.peek();
            int theifPosition = theifs.peek();
            // If the thief is within catching range of the policeman
            if (Math.abs(policePosition - theifPosition) <= k) {
                theifsCount++;
            }
            // If the thief is too far to the left of the policeman
            else if (theifPosition < policePosition) {
                polices.poll();// Remove the thief (move thief pointer forward)
            }
            // If the policeman is too far to the left of the thief
            else if (policePosition < theifPosition) {
                theifs.poll();  // Remove the policeman (move police pointer forward)
            }
        }
        return theifsCount;

    }

    public static void main(String[] args) {
        char[] arr = {'T', '.', 'P', '.', 'T', '.', '.', 'P'};
        int k = 2;  // Range within which a policeman can catch a thief
        int result =findMaxTheif(arr, k);
        System.out.println("Maximum thieves caught: " + result);
    }

}
