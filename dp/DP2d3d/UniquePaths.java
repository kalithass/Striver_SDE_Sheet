package strivers.dp.DP2d3d;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/unique-paths
public class UniquePaths implements App {

    @Override
    public void run() {
        int m = 3, n = 7;
        int res = uniquePaths(m, n);
        System.out.println(res);
    }

    public int uniquePaths(int m, int n) {
//        return recursiveApproach(m, n);
        return dpApproach(m, n);
    }

    private int dpApproach(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;
        for (int i=m-1;i>=0;i--) {
            for (int j=n-1;j>=0;j--) {
                if (i == m-1 && j==n-1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    private int recursiveApproach(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        return recursiveHelper(0,0, m, n, dp);
    }

    private int recursiveHelper(int row, int col, int m, int n, int[][] dp) {
        if (row == m || col == n) return 0;
        if (row == m-1 && col == n-1) return 1;
        return dp[row][col] = recursiveHelper(row+1, col, m, n, dp) + recursiveHelper(row, col+1, m, n, dp);
    }
}
