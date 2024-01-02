package strivers.dp.DpOnSubSequence;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/rod-cutting-problem_800284
public class RodCut  implements App {


    @Override
    public void run() {
        int[] price = {2,5,7,8,10};
        int n = price.length;
        int res = cutRod(price, n);
        System.out.println(res);
    }

    // maximum subset sum
    public static int cutRod(int[] price, int n) {
        int[][] dp = new int[n][n +1];
        for(int[] ar : dp) {
            Arrays.fill(ar, -1);
        }
        return cutRodMemoization(price, 0, n, dp);
    }

    private static int cutRodMemoization(int[] price, int index, int amount, int[][] dp) {
        if(index == price.length || amount==0) return 0;
        if(dp[index][amount] != -1) return dp[index][amount];
        int notPick = cutRodMemoization(price, index+1, amount, dp);
        int pick = Integer.MIN_VALUE;
        if(amount-(index+1) >= 0) {
            pick = price[index] + cutRodMemoization(price, index, amount-(index+1), dp);
        }
        return dp[index][amount] = Math.max(pick, notPick);

    }
}
