package strivers.dp.DpOnSubSequence;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/
public class MinimumCoins implements App {


    @Override
    public void run() {
        int[] coins = {1,2,5};
        int amount = 11;
        int res = coinChange(coins, amount);
        System.out.println(res);
    }

    public int coinChange(int[] coins, int amount) {
        return recursiveApproach(coins, amount);
    }

    private int recursiveApproach(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        int res = recursiveHelper(coins, amount, 0, dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int recursiveHelper(int[] coins, int amount, int i, int[][] dp) {
        if (amount == 0) return 0;
        if (i == coins.length) return Integer.MAX_VALUE;

        if (dp[i][amount] != -1) return dp[i][amount];

        int pick = Integer.MAX_VALUE;
        if (amount - coins[i] >= 0) {
            int val = recursiveHelper(coins, amount-coins[i], i,  dp);
            if (val != Integer.MAX_VALUE) pick = 1 + val;
        }
        int notPick = recursiveHelper(coins, amount, i+1, dp);
        // System.out.println(pick+" "+notPick);
        return dp[i][amount] = Math.min(pick, notPick);
    }
}
