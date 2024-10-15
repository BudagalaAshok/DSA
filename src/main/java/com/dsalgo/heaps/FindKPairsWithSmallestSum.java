package com.dsalgo.heaps;

import java.util.*;

public class FindKPairsWithSmallestSum {


    /**
     * First we will try with brute force solution, first generate all pairs from the given arrays
     * Sort the pairs by calculating the sum and then return the sublist up to k
     */

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> pairs = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {

            for (int j = 0; j < nums2.length; j++) {

                List<Integer> pair = new ArrayList<>();
                pair.add(nums1[i]);
                pair.add(nums2[j]);
                pairs.add(pair);
            }
        }

        //Step2 Sort based on the sum
        Collections.sort(pairs, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int sum1 = o1.get(0) + o1.get(1);
                int sum2 = o2.get(0) + o2.get(1);
                //if the value is negative that means pair 1 is small so pair1 should come first
                // if the value is equal to zero then both are same no need to change the order
                //If the value is positive then pair2 is small so pair2 should come first
                return sum1 - sum2;
            }
        });

        return pairs.subList(0, Math.min(k, pairs.size()));

    }

    //Optimal solution using heap instead of generating pairs first we can directly push the min sum pairs to the heap
    //And then pop up to k from heap ?

    /**
     * First step is to create a min heap and sort the values based on the sum and generate pairs by iterating second array by putting the pair
     * of first element in first array and the elements in second array
     * Next is to iterate until heap is empty and k!0 then poll the pairs from the queue and if there is any next element is available in nums1
     * array and push that element and that index also in to queue, once we pop the element then we add that pair to our list
     */

    public List<List<Integer>> kSmallestPairsUsingHeaps(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> pairs = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (o1, o2) -> {
                    return (o1[0] + o1[1]) - (o2[0] + o2[1]);
                });

        for (int i = 0; i < nums2.length; i++) {

            if (nums1.length > 0) {
                heap.offer(new int[]{nums1[0], nums2[i], 0, i});
            }

        }

        //Now iterate until k!0 and heap is empty
        while (k-- > 0 && !heap.isEmpty()) {
            int[] currentPair = heap.poll();
            //Now add the pair
            pairs.add(Arrays.asList(currentPair[0], currentPair[1]));
            int nums1Index = currentPair[2];
            int nums2Index = currentPair[3];
            //Check for next element exists in nums1 array
            if (nums1Index + 1 < nums1.length) {
                heap.offer(new int[]{nums1[nums1Index + 1], nums2[nums2Index], nums1Index + 1, nums2Index});
            }
        }
        return pairs;

    }


    public static void main(String[] args) {
        FindKPairsWithSmallestSum findKPairsWithSmallestSum = new FindKPairsWithSmallestSum();
        //findKPairsWithSmallestSum.kSmallestPairs(new int[]{1, 2, 3}, new int[]{3, 4, 5}, 2);
        List<List<Integer>> pairs = findKPairsWithSmallestSum.kSmallestPairsUsingHeaps(new int[]{1, 1, 2}, new int[]{1,2,3}, 2);
        pairs.forEach(System.out::println);
    }

}
