package strivers.dp.dpOnStock;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeToBuyAndSellStockII implements App {


    @Override
    public void run() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = maxProfit(prices);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
//        return recursiveApproach(prices);
//        return dpApproach(prices);
        return simplifiedDpApproach(prices);
    }

    private int simplifiedDpApproach(int[] prices) {
        int n = prices.length;

        int buy = 0, sell = 0;
        for (int i = n - 1; i >= 0; i--) {
            int currBuy  = Math.max(-prices[i] + sell, buy);
            int currSell = Math.max(prices[i] + buy, sell);
            buy = currBuy;
            sell = currSell;
        }
        return buy;
    }

    private int dpApproach(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];

        for (int i=n-1;i>=0;i--) {
            for(int buyOrSell=0;buyOrSell<=1;buyOrSell++) {
                if (buyOrSell == 1) {
                    dp[i][buyOrSell] = Math.max(
                            -prices[i] + dp[i+1][0],
                            dp[i+1][1]);
                } else { // buyOrSell == 0
                    dp[i][buyOrSell] = Math.max(
                            prices[i] + dp[i+1][1],
                            dp[i+1][0]);
                }
            }
        }

        return dp[0][1];
    }

    private int recursiveApproach(int[] prices) {
        int[][] dp = new int[prices.length][2];

        for (int[] row : dp) Arrays.fill(row, -1);

        // 1 -> we can buy, 0 -> we can sell
        return recursiveHelper(prices, 0, 1, dp);
    }

    private int recursiveHelper(int[] prices, int i, int buyOrSell, int[][] dp) {
        if (i == prices.length) return 0;

        if (dp[i][buyOrSell] != -1) return dp[i][buyOrSell];
        if (buyOrSell == 1) {
            return dp[i][buyOrSell] = Math.max(
                    -prices[i] + recursiveHelper(prices, i + 1, 0, dp), // I have bought the stock so sell it on upcoming day
                    recursiveHelper(prices, i + 1, 1, dp)); // I don't want to buy now, we can still buy on upcoming day
        } else { // buyOrSell == 0
            return dp[i][buyOrSell] = Math.max(
                    prices[i] + recursiveHelper(prices, i + 1, 1, dp), // I have sold the stock, so buy the stock in upcoming day
                    recursiveHelper(prices, i + 1, 0, dp) // I don't want to sell now, so lets sell on other day
            );
        }
    }
}
