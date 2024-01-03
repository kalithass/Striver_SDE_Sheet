package strivers.dp.dpOnStock;


import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
public class BestTimeToSellWithTransactionFee implements App {
    @Override
    public void run() {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        int res = maxProfit(prices, fee);
        System.out.println(res);
    }

    public int maxProfit(int[] prices, int fee) {
        return recursiveApproach(prices, fee);
    }

    private int recursiveApproach(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        for (int[] row : dp) Arrays.fill(row, -1);
        return recursiveHelper(prices, fee, 0, 1, dp);
    }

    private int recursiveHelper(int[] prices, int fee, int i, int buyOrSell, int[][] dp) {
        if (i == prices.length) return 0;

        if (dp[i][buyOrSell] != -1) return dp[i][buyOrSell];

        int pick, notPick;
        if (buyOrSell == 1) {
            pick = -prices[i] + recursiveHelper(prices, fee, i+1, 0, dp);
            notPick = recursiveHelper(prices, fee, i+1, 1, dp);
        } else {
            pick =  prices[i] + recursiveHelper(prices, fee, i+1, 1, dp) - fee;
            notPick = recursiveHelper(prices, fee, i+1, 0, dp);
        }

        return dp[i][buyOrSell] = Math.max(pick, notPick);
    }
}
