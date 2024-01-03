package strivers.dp.dpOnStock;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class BestTimeToBuyAndSellStockWithCoolDown implements App {
    @Override
    public void run() {
        int[] prices = {1,2,3,0,2};
        int  k = 2;
        int res = maxProfit(prices);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        return recursiveApproach(prices);
    }

    private int recursiveApproach(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int row[] : dp) Arrays.fill(row, -1);
        return recursiveHelper(prices, 0, 1, dp);
    }

    private int recursiveHelper(int[] prices, int i, int buyOrSell, int[][] dp) {
        if (i >= prices.length) return 0;
        int pick;
        int notPick;

        if (dp[i][buyOrSell] != -1) return dp[i][buyOrSell];

        if (buyOrSell == 1) {
            pick = -prices[i] + recursiveHelper(prices, i + 1, 0, dp);
            notPick = recursiveHelper(prices, i + 1, 1, dp);
        } else {
            // transaction completed, so skip  the next i
            pick = prices[i] + recursiveHelper(prices, i + 2, 1, dp);
            notPick = recursiveHelper(prices, i + 1, 0, dp);
        }
        return dp[i][buyOrSell] = Math.max(pick, notPick);
    }
}
