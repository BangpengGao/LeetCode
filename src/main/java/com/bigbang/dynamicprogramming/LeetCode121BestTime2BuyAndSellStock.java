package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/11
 * @since 1.0.0
 */
public class LeetCode121BestTime2BuyAndSellStock {
    /**
     * You are given an array prices where prices[i] is the price of a given stock on the ith day.
     * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
     * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: prices = [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
     * <p>
     * Example 2:
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transactions are done and the max profit = 0.
     * <p>
     * <p>
     * Constraints:
     * 1 <= prices.length <= 105
     * 0 <= prices[i] <= 104
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        // solution - 1
//        int len = prices.length, solution = 0;
//        for (int i = 0; i < len; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (prices[i] < prices[j] && prices[j] - prices[i] > solution)
//                    solution = prices[j] - prices[i];
//            }
//        }
//        return solution;


        // solution - 2
        // Runtime: 3 ms, faster than 37.53% of Java online submissions for Best Time to Buy and Sell Stock.
        // Memory Usage: 105.5 MB, less than 16.81% of Java online submissions for Best Time to Buy and Sell Stock.
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(prices));
    }
}
