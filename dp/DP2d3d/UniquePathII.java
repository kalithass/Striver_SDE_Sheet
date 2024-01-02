package strivers.dp.DP2d3d;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/unique-paths-ii/
public class UniquePathII implements App {

    @Override
    public void run() {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int res = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(res);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return recursiveApproach(obstacleGrid);
//        return dpApproach(m, n);
    }

    private int dpApproach(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[m-1][n-1] == 1) return 0;
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = 1;

        for (int i =m-1;i>=0;i--) {
            for (int j=n-1;j>=0;j--) {
                if ((i == m-1 && j == n-1) || grid[i][j] == 1) continue;
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];
    }

    private int recursiveApproach(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return  recursiveHelper(0,0, grid, dp);
    }

    private int recursiveHelper(int row, int col, int[][] grid, int[][] dp) {
        if (row == grid.length || col == grid[0].length) return 0;
        if (grid[row][col] == 1) return 0;
        if (row == grid.length-1 && col == grid[0].length-1) return 1;
        if (dp[row][col] != -1) return dp[row][col];
        return dp[row][col] = recursiveHelper(row+1, col,grid, dp) +
                recursiveHelper(row, col+1, grid, dp);
    }
}
