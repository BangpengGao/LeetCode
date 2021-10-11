package com.bigbang.dynamicprogramming;

/**
 * @author Bang Peng
 * @version 1.0.0
 * @date 2021/10/11
 * @since 1.0.0
 */
public class LeetCode122BestTime2BuyAndSellStockII {
    /**
     * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
     * On each day, you may decide to buy and/or sell the stock.
     * You can only hold at most one share of the stock at any time.
     * However, you can buy it then immediately sell it on the same day.
     * Find and return the maximum profit you can achieve.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Total profit is 4 + 3 = 7.
     * <p>
     * Example 2:
     * Input: prices = [1,2,3,4,5]
     * Output: 4
     * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
     * Total profit is 4.
     * <p>
     * Example 3:
     * Input: prices = [7,6,4,3,1]
     * Output: 0
     * Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
     * <p>
     * <p>
     * Constraints:
     * 1 <= prices.length <= 3 * 104
     * 0 <= prices[i] <= 104
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        //Runtime: 1 ms, faster than 72.64% of Java online submissions for Best Time to Buy and Sell Stock II.
        //Memory Usage: 41.3 MB, less than 21.58% of Java online submissions for Best Time to Buy and Sell Stock II.
        int maxProfit = 0, tempMaxProfit = 0, temp = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int dif = prices[i] - temp;
            if (dif >= tempMaxProfit) {
                tempMaxProfit = dif;
            } else {
                temp = prices[i];
                maxProfit += tempMaxProfit;
                tempMaxProfit = 0;
            }
        }
        return maxProfit+tempMaxProfit;
    }

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
