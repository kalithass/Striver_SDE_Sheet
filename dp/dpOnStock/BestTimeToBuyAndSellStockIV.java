package strivers.dp.dpOnStock;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
public class BestTimeToBuyAndSellStockIV implements App {


    @Override
    public void run() {
        int[] prices = {2,4,1};
        int  k = 2;
        int res = maxProfit(k, prices);
        System.out.println(res);
    }

    public int maxProfit(int k, int[] prices) {
//        return recursiveApproach(k, prices);
        return dpApproach(k, prices);
    }

    private int dpApproach(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];

        for (int i=n-1;i>=0;i--) {
            for (int buyOrSell = 0;buyOrSell<=1;buyOrSell++) {
                for (int transaction = k-1;transaction>=0;transaction--) {

                    int pick;
                    int notPick;
//                    System.out.println("buyorselll "+ buyOrSell+" i "+i+" k "+k);
                    if (buyOrSell == 1) {
                        // sell stock on next time
                        pick = -prices[i] + dp[i+1][0][transaction];

                        // we can still buy stock on next time
                        notPick = dp[i+1][1][transaction];

                    } else { // buyOrSell == 0
                        // buy stack on next time
                        // single sell indicates the entire transaction
                        pick = prices[i] + dp[i+1][1][transaction+1];

                        // we can still sell stock on next time
                        notPick = dp[i+1][0][transaction];

                    }
                    dp[i][buyOrSell][transaction] =Math.max(pick, notPick);
                }
            }
        }
        return dp[0][1][0];
    }

    private int recursiveApproach(int k, int[] prices) {
        int[][][] dp = new int[prices.length][2][k];
        for (int[][] table : dp) {
            for (int[] arr : table) Arrays.fill(arr, -1);
        }
        return recursiveHelper(prices, 0, 1, 0, k, dp);
    }

    private int recursiveHelper(int[] prices, int i, int buyOrSell, int transaction, int k, int[][][] dp) {
        if (i == prices.length || transaction == k) return 0;

        if (dp[i][buyOrSell][transaction] != -1) return dp[i][buyOrSell][transaction];

        // we can buy now
        int pick;
        int notPick;
        if (buyOrSell == 1) {
            // sell stock on next time
            pick = -prices[i] + recursiveHelper(prices, i + 1, 0, transaction, k, dp);

            // we can still buy stock on next time
            notPick = recursiveHelper(prices, i + 1, 1, transaction, k, dp);

        } else { // buyOrSell == 0
            // buy stack on next time
            // single sell indicates the entire transaction
            pick = prices[i] + recursiveHelper(prices, i + 1, 1, transaction + 1, k, dp);

            // we can still sell stock on next time
            notPick = recursiveHelper(prices, i + 1, 0, transaction, k, dp);

        }
        return dp[i][buyOrSell][transaction] =Math.max(pick, notPick);
    }

}
