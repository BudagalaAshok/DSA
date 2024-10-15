package com.dsalgo.arrays;

public class BuyAndSellStockII {

    /**
     Here we are solving this problem using greedy approach because we can buy and sell stock so many times
     And find the maximumProfit in this process if the current stock price is greater than previous day then we take the difference
     and it to the profit
     */
    public int maxProfit(int[] prices) {

        int totalProfit=0;
        for(int i=1;i<prices.length;i++){

            if(prices[i]>prices[i-1]){
                totalProfit+=prices[i]-prices[i-1];
            }
        }
        return totalProfit;
    }
}
