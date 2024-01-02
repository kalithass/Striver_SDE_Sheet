package strivers.dp.DpOnSubSequence;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change-ii/
public class CoinChangeII implements App {


    @Override
    public void run() {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int res = change(amount, coins);
        System.out.println(res);
    }

    public int change(int amount, int[] coins) {
        return recursiveApproach(amount, coins);
    }

    private int recursiveApproach(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for(int[] rows:dp) Arrays.fill(rows, -1);
        return recursiveHelper(amount, coins, 0, dp);
    }

    private int recursiveHelper(int amount, int[] coins, int i, int[][] dp) {
        if (amount == 0) return 1;
        if (i == coins.length) return 0;
        if (dp[i][amount] != -1) return dp[i][amount];
        int res = 0;
        if (amount - coins[i] >= 0) res = recursiveHelper(amount - coins[i], coins, i, dp);
        return dp[i][amount] = res + recursiveHelper(amount, coins, i + 1, dp);
    }
}
