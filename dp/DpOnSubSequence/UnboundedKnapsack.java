package strivers.dp.DpOnSubSequence;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/unbounded-knapsack_1215029
public class UnboundedKnapsack implements App {


    @Override
    public void run() {
        int[] weight = {1,2,4,5};
        int[] value = {5,4,8,6};
        int n = weight.length;
        int maxWeight = 10;
        int res = unboundedKnapsack(n, maxWeight, value, weight);
        System.out.println(res);
    }

    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        return recursiveApproach(n, w, profit, weight);
    }

    private static int recursiveApproach(int n, int w, int[] profit, int[] weight) {
        int[][] dp = new int[n][w+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return recursiveHelper(w, profit, weight, 0, dp);
    }

    private static int recursiveHelper(int currWeight, int[] profit, int[] weight, int i, int[][] dp) {
        if (currWeight == 0) return 0;
        if (i == profit.length) return 0;

        if (dp[i][currWeight] != -1) return dp[i][currWeight];
        int pick = 0;
        if (currWeight - weight[i] >= 0) {
            pick = profit[i] + recursiveHelper(currWeight-weight[i], profit, weight, i, dp);
        }
        int notPick = recursiveHelper(currWeight, profit, weight, i+1, dp);
        return dp[i][currWeight] = Math.max(pick, notPick);
    }
}
