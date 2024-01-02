package strivers.dp.DpOnSubSequence;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/0-1-knapsack_920542
public class Knapsack implements App {


    @Override
    public void run() {
        int[] weight = {1,2,4,5};
        int[] value = {5,4,8,6};
        int n = weight.length;
        int maxWeight = 5;
        int res = knapsack(weight, value, n, maxWeight);
        System.out.println(res);
    }

    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
//        return recursiveApproach(weight, value, n, maxWeight);
        return dpApproach(weight, value, n, maxWeight);
    }

    private static int dpApproach(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n+1][maxWeight+1];
        for(int i=n-1;i>=0;i--) {
            for (int j = maxWeight;j>=0;j--) {
                // 0 should be assigned, that is the default value
                if (j == maxWeight) continue;

                int pick = 0;
                if (j + weight[i] <= maxWeight) {
                    pick = value[i] +dp[i+1][weight[i]+j];
                }
                int notPick =  dp[i+1][j];
                dp[i][j] = Math.max(pick, notPick);

            }
        }
        return dp[0][0];
    }

    private static int recursiveApproach(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp = new int[n][maxWeight];
        for (int[] row : dp) Arrays.fill(row, -1);
        return recursiveHelper(weight, value, 0, 0, maxWeight, dp);
    }

    private static int recursiveHelper(int[] weight, int[] value, int currWeight, int i, int maxWeight, int[][] dp) {
        if (currWeight == maxWeight) return 0;
        if (i == weight.length) return 0;
        int pick = 0;
        if (dp[i][currWeight] != -1) return dp[i][currWeight];
        if (currWeight + weight[i] <= maxWeight) {
            pick = value[i] + recursiveHelper(weight, value, currWeight+weight[i], i+1, maxWeight, dp);
        }
        int notPick =  recursiveHelper(weight, value, currWeight, i+1, maxWeight, dp);
        return dp[i][currWeight] = Math.max(pick, notPick);
    }
}
