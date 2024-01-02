package strivers.dp.DP2d3d;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-path-sum/
public class MinimumPathSum implements App {

    @Override
    public void run() {
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        int res = minPathSum(grid);
        System.out.println(res);
    }

    public int minPathSum(int[][] grid) {
        return recursiveApproach(grid);
//        return dpApproach(m, n);
    }

    private int dpApproach(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[m], Integer.MAX_VALUE);
        for (int i=0;i<m+1;i++) {
            dp[i][n] =  Integer.MAX_VALUE;
        }

        for (int i=m-1;i>=0;i--) {
            for (int j=n-1;j>=0;j--) {
                if (i == m-1 && j==n-1) {
                    dp[i][j] = grid[i][j];
                    continue;
                }
                int down = dp[i+1][j];
                int right = dp[i][j+1];
                dp[i][j] = grid[i][j] + Math.min(down, right);
            }
        }

        return dp[0][0];
    }

    private int recursiveApproach(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return recursiveHelper(0, 0, grid, dp);
    }

    private int recursiveHelper(int row, int col, int[][] grid, int[][] dp) {
        if (row == grid.length || col == grid[0].length) return Integer.MAX_VALUE;
        if (row == grid.length - 1 && col == grid[0].length - 1) return grid[row][col];

        if (dp[row][col]  != -1) return dp[row][col];

        int down = recursiveHelper(row + 1, col, grid, dp);
        int right = recursiveHelper(row, col + 1, grid, dp);
        return dp[row][col] = grid[row][col] + Math.min(down, right);

    }
}
