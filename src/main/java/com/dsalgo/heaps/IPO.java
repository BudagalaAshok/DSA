package com.dsalgo.heaps;


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources,
 * it can only finish at most k distinct projects before the IPO. Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
 * You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
 * Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 * Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
 * The answer is guaranteed to fit in a 32-bit signed integer.
 */
public class IPO {

    //Brute force solution, O(n*k)
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        //Taken array to track that project got taken or not
        boolean[] taken=new boolean[capital.length];

        for (int i = 0; i < k; i++) {

            int maxProfit=Integer.MIN_VALUE;
            int maxProfitIndex=-1;

            for (int j = 0; j < capital.length; j++) {

                if(!taken[j] && capital[j]<=w){

                    if(profits[j]>maxProfit){
                        maxProfit=profits[j];
                        maxProfitIndex=j;
                    }

                }

            }
            //No project we can't take
            if(maxProfitIndex==-1){
                break;
            }
            taken[maxProfitIndex]=true;
            w+=maxProfit;

        }

        return w;


    }

    //Optimal solution using heaps

    /**
     * Step1 first push all the capital and respective profit to min heap, so that based on the capital (ascending order) will be stored in priority queue
     * Step2 now iterate up to k times and iterate minHeap until it is empty and if any of the capital <=w then we push in to maxHeap with profit and capital
     * We define MaxHeap with capital and profit and sort descending order by profit so we have maxProfit capital will be at the top
     * Once done if maxHeap is empty then we didn't find any capital otherwise take the top profit and add it to our capital, repeat until k times
     */
    public int findMaximizedCapitalUsingHeaps(int k, int w, int[] profits, int[] capital) {

        int n=profits.length;
        //Defining minHeap with capital and profit we sort in ascending order by capital
        PriorityQueue<int[]> minHeap=new PriorityQueue<>(Comparator.comparingInt(value->value[0]));

        //Define maxHeap with capital and profit and we sort based on profit(descending order)
        //Reversing natural order, if the value is positive then b should come before a, the value is equal no order,the value is negative then a should come before b
        PriorityQueue<int[]> maxHeap=new PriorityQueue<>((a,b) -> b[1]-a[1]);

        //Now push all the capitals along with the profit in to minheap
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[]{capital[i],profits[i]});
        }

        //now iterate up to k projects
        for (int i = 0; i < k; i++) {

            //now iterate minHeap if any project found with capital <=w push that capital and profit in to the queue
            while (!minHeap.isEmpty() && minHeap.peek()[0] <=w){
                //remove and push to the heap
                maxHeap.offer(minHeap.poll());
            }

            //No project with the required capital so breaking
            if(maxHeap.isEmpty()){
                break;
            }
            //Once we found take the profit and remove
            w+=maxHeap.poll()[1];

        }
        return w;
    }

    public static void main(String[] args) {
        IPO ipo = new IPO();
        int k = 2;
        int W = 0;  // Initial capital
        int[] Profits = {1, 2, 3};
        int[] Capital = {0, 1, 1};

        int result = ipo.findMaximizedCapital(k, W, Profits, Capital);
        System.out.println("Maximized Capital: " + result);
        System.out.println("Maximized Capital using optimized approach :"+ipo.findMaximizedCapitalUsingHeaps(k, W, Profits, Capital));

    }


}
