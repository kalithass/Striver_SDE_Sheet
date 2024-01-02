package strivers.dp.DP2d3d;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-falling-path-sum/
public class MinFailingPathSum implements App {

    @Override
    public void run() {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        int res = minFallingPathSum(matrix);
        System.out.println(res);
    }

    public int minFallingPathSum(int[][] matrix) {
//        return recursiveApproach(matrix);
        return dpApproach(matrix);
    }

    private int dpApproach(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);


        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if(i == n-1) {
                    dp[i][j] = matrix[i][j];
                    continue;
                }
                int leftBottom = Integer.MAX_VALUE, rightBottom = Integer.MAX_VALUE;
                int bottom = dp[i+1][j];
                if (j - 1 >= 0) leftBottom = dp[i+1][j-1];
                if (j + 1 < matrix[i].length) rightBottom = dp[i+1][j+1];

                dp[i][j] = matrix[i][j] + Math.min(bottom, Math.min(leftBottom, rightBottom));
            }
        }

        for (int i = 0; i < m; i++) {
            res = Math.min(res, dp[0][i]);
        }
        return res;
    }

    private int recursiveApproach(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            res = Math.min(res, recursiveHelper(matrix, 0, i, dp));
        }
        return res;
    }

    private int recursiveHelper(int[][] matrix, int row, int col, int[][] dp) {
        if (row == matrix.length - 1) return matrix[row][col];

        if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        int leftBottom = Integer.MAX_VALUE, rightBottom = Integer.MAX_VALUE;
        int bottom = recursiveHelper(matrix, row + 1, col, dp);
        if (col - 1 >= 0) leftBottom = recursiveHelper(matrix, row + 1, col - 1, dp);
        if (col + 1 < matrix[row].length) rightBottom = recursiveHelper(matrix, row + 1, col + 1, dp);
        return dp[row][col] = matrix[row][col] + Math.min(bottom, Math.min(leftBottom, rightBottom));
    }
}
