package com.dsalgo.dp;

import java.util.Arrays;

public class BuyAndSellStock {


    //This is one time we can buy and one time we can sell then we need to find the maximum profit

    public int maxProfit(int[] stocks) {

        /*
          Here the initution is we need to find the min amount in the previous days while we are planning to sell.
           That means whenever the price is low then only we will buy. Based on that we wil keep track of maxProfit and minimum
         */

        int min = stocks[0];
        int maxProfit = 0;
        int n = stocks.length;
        int minTrack = min;

        for (int i = 1; i < n; i++) {
            int cost = stocks[i] - min;
            maxProfit = Math.max(maxProfit, cost);
            min = Math.min(min, stocks[i]);
            if (min != minTrack) {
                minTrack = min;
            }
        }
        return maxProfit;

    }

    /*
     We can buy an no of times and sell any no of times but it should be in order like first buy and then sell
     Now we need to find all profits and then find max profit
     Here operation defines 1 means buy and 0 means sell
     */

    /**
     * Recursive rules -> Express every thing in terms of indexes and second one is do all operations on that index(Recurrence Relation) and final step is base case
     *
     * @param stocks
     * @param index
     * @param operation
     * @param n
     * @return
     */

    public int buyAndSellStocks(int[] stocks, int index, int operation, int n) {

        int profit = 0;
        //Base case
        //This means we buy a stock but at the end of all days we didn't sold then profit we make it as zero
        if (index == n) {
            return 0;
        }

        //Here we have two cases one is buy and sell, first one is customer want to buy then in that case money is going from his side
        if (operation == 1) {
            //Here again we have two cases one is customer want to buy and he don't want to buy on that day
            //We are maintaining the previous operation because if he bought then we can't buy again and if he sold previous he can't sold again
            //first use case he bought that's why amount got reduced and moving to the next day with operation as sell and incase he don't want to buy because the price is higher then move to next day
            // with operation as buy again
            profit = Math.max(-stocks[index] + buyAndSellStocks(stocks, index + 1, 0, n), buyAndSellStocks(stocks, index + 1, 1, n));

        } else {
            //Here again we have two cases one is customer want to sell and he don't want to sell on that day
            //We are maintaining the previous operation because if he bought then we can't buy again and if he sold previous he can't sold again
            //first use case he sold that's why amount got amount and moving to the next day with operation as buy again and incase he don't want to sell because the price is lower then move to next day
            // with operation as buy again
            profit = Math.max(stocks[index] + buyAndSellStocks(stocks, index + 1, 1, n), buyAndSellStocks(stocks, index + 1, 0, n));
        }
        return profit;


    }

    public int buyAndSellStocksUsingMemoization(int[] stocks, int index, int operation, int n, int[][] dp) {

        int profit = 0;
        //Base case
        //This means we buy a stock but at the end of all days we didn't sold then profit we make it as zero
        if (index == n) {
            return 0;
        }

        if (dp[index][operation] != -1) {
            return dp[index][operation];
        }

        //Here we have two cases one is buy and sell, first one is customer want to buy then in that case money is going from his side
        if (operation == 1) {
            //Here again we have two cases one is customer want to buy and he don't want to buy on that day
            //We are maintaining the previous operation because if he bought then we can't buy again and if he sold previous he can't sold again
            //first use case he bought that's why amount got reduced and moving to the next day with operation as sell and incase he don't want to buy because the price is higher then move to next day
            // with operation as buy again
            dp[index][profit] = Math.max(-stocks[index] + buyAndSellStocks(stocks, index + 1, 0, n), buyAndSellStocks(stocks, index + 1, 1, n));

        } else {
            //Here again we have two cases one is customer want to sell and he don't want to sell on that day
            //We are maintaining the previous operation because if he bought then we can't buy again and if he sold previous he can't sold again
            //first use case he sold that's why amount got amount and moving to the next day with operation as buy again and in-case he don't want to sell because the price is lower then move to next day
            // with operation as buy again
            dp[index][profit] = Math.max(stocks[index] + buyAndSellStocks(stocks, index + 1, 1, n), buyAndSellStocks(stocks, index + 1, 0, n));
        }
        return dp[index][profit];


    }

    public int buyAndSellStockUsingTabulation(int[] stocks, int n) {

        int[][] dp = new int[n + 1][2];

        //Base case
        // case when we had exhausted the number of days of the stock market
        dp[n][0] = 1;
        dp[n][1] = 1;

        //Now we have two variables got changes one is day and operation(buy or stock)
        //Start from last day
        for (int i = n - 1; i >= 0; i--) {

            for (int buy = 0; buy <= 1; buy++) {

                if (buy == 0) { //we can buy the stock
                    dp[i][buy] = Math.max(-stocks[i] + dp[i + 1][1], dp[i + 1][0]);

                }
                if (buy == 1) { //we can sell the stock
                    dp[i][buy] = Math.max(stocks[i] + dp[i + 1][0], dp[i + 1][1]);
                }

            }

        }
        //This was the final answer we have the maximum profilt
        return dp[0][0];

    }

    public static void main(String[] args) {

        int[] arr = new int[]{100, 180, 260, 310, 40, 535, 695};
        BuyAndSellStock buyAndSellStock = new BuyAndSellStock();
        System.out.println("Max Profit we can make is :" + buyAndSellStock.maxProfit(arr));
        int n = arr.length;
        int[][] dp = new int[n][2];
        for (int[] eachArray : dp) {
            Arrays.fill(eachArray, -1);
        }
        buyAndSellStock.buyAndSellStocksUsingMemoization(arr, 0, 1, n, dp);

    }


}
