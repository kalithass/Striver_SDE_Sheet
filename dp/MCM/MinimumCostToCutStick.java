package strivers.dp.MCM;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
public class MinimumCostToCutStick  implements App {

    @Override
    public void run() {
        int[] arr = {1,3,4,5};
        int n = 7;
        int res = minCost(n, arr);
        System.out.println(res);
    }

    public int minCost(int n, int[] cuts) {
        int[] arr = getCutExtendedArray(n, cuts);
//        return recursiveApproach(arr);
        return dpApproach(arr);
    }

    private static int[] getCutExtendedArray(int n, int[] cuts) {
        int[] arr = new int[cuts.length+2];
        for (int i = 0; i< cuts.length; i++) arr[i+1] = cuts[i];
        arr[0] = 0;
        arr[cuts.length+1] = n;
        Arrays.sort(arr);
        return arr;
    }

    private int dpApproach(int[] cuts) {
        int n = cuts.length;
        int[][] dp = new int[n][n];

        for (int i=n-2;i>=1;i--) {
            for (int j=i;j<=n-2;j++) {
                int min = Integer.MAX_VALUE;
                for (int k=i;k<=j;k++) {
                    int curr = cuts[j+1] - cuts[i-1] +
                            dp[i][k-1] + dp[k+1][j];
                    min = Math.min(min, curr);
                }

                dp[i][j] = min;
            }
        }
        return dp[1][n-2];
    }

    private int recursiveApproach(int[] cuts) {
        int n = cuts.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return recursiveHelper(1, cuts.length-2, cuts,dp);
    }

    private int recursiveHelper(int i, int j, int[] cuts, int[][] dp) {
        if (i>j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k=i;k<=j;k++) {
            int curr = cuts[j+1] - cuts[i-1] +
                    recursiveHelper(i, k-1, cuts, dp) + recursiveHelper(k+1, j, cuts, dp);
            min = Math.min(min, curr);
        }

        return dp[i][j] = min;
    }
}
