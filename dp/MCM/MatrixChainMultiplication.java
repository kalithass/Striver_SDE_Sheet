package strivers.dp.MCM;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/matrix-chain-multiplication_624880
public class MatrixChainMultiplication implements App {

    @Override
    public void run() {
        int[] arr = {10,15,15,25};
        int res = mcm(arr);
        System.out.println(res);
    }

    public static int mcm(int[] p){
//        return recursiveApproach(p);
        return dpApproach(p);
    }

    private static int dpApproach(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];

        for (int i=n-1;i>=1;i--) {
            for (int j=i+1;j<n;j++) {
                int min = Integer.MAX_VALUE;
                for (int k=i;k<j;k++) {
                    int curr = dp[i][k] + dp[k+1][j] +
                            (p[i-1] * p[k] * p[j]);
                    min = Math.min(min, curr);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n-1];
    }

    private static int recursiveApproach(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return recursiveHelper(1, n-1, p, dp);
    }

    private static int recursiveHelper(int i, int j, int[] p, int[][] dp) {
        if (i == j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k=i;k<j;k++) {
            int curr = recursiveHelper(i,k, p, dp) + recursiveHelper(k+1, j, p, dp) +
                    p[i-1] * p[k] * p[j];
            min = Math.min(min, curr);
        }
        return dp[i][j] = min;
    }
}
