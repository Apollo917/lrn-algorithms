package com.apollo.leetcode.medium;

/**
 * 122. Best Time to Buy and Sell Stock II
 * <p>
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 *
 * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">Best Time to Buy and Sell Stock II<a/>
 */
public class BestTimeToBuyAndSellStockII {

    public int start(int[] prices) {
        int result = 0;

        for (int i = prices.length - 1; i > 0; i--) {
            int currPrice = prices[i];
            int prevPrice = prices[i - 1];

            if (prevPrice < currPrice) {
                result += currPrice - prevPrice;
            }
        }

        return result;
    }
}
