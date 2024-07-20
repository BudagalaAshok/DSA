package com.dsalgo.heaps;

import com.google.common.collect.Lists;

import java.util.*;


public class FindMedianOfSubArray {

    public static void solve(int[] arr, int n) {

        Comparator<Integer> maxHeapComparator = (o1, o2) -> o2 - o1;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(maxHeapComparator);

        Collections.sort(Lists.newArrayList("Ashok"), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });

        //Another way of writing the same thing using below
        //PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        maxHeap.add(arr[0]);
        System.out.print(maxHeap.peek() + " ");
        for (int i = 1; i < n; i++) {
            int x = arr[i];
            if (!maxHeap.isEmpty() && x > maxHeap.peek()) {
                minHeap.add(x);
            } else {
                maxHeap.add(x);
            }
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.peek());
                minHeap.poll();
            } else if (maxHeap.size() - minHeap.size() >= 2) {
                minHeap.add(maxHeap.peek());
                maxHeap.poll();
            }
            System.out.print(maxHeap.peek() + " ");
        }


    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Main. */
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        for (int i = 0; i < noOfTestCases; i++) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int j = 0; j < size; j++) {
                arr[j] = sc.nextInt();
            }
            solve(arr, size);
            System.out.println();
        }
    }
}