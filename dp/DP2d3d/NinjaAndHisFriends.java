package strivers.dp.DP2d3d;

import strivers.App;

//https://www.codingninjas.com/studio/problems/chocolate-pickup_3125885
public class NinjaAndHisFriends implements App {

    @Override
    public void run() {
        int[][] matrix = {{2, 3, 1, 2}, {3, 4, 2, 2}, {5, 6, 3, 5}};
        int r = matrix.length;
        int c = matrix[0].length;
        int res = maximumChocolates(r, c, matrix);
        System.out.println(res);
    }

    public static int maximumChocolates(int r, int c, int[][] grid) {
//        return recursiveApproach(r, c, grid);
        return dpApproach(r,c,grid);
    }

    private static int dpApproach(int r, int c, int[][] grid) {
        int[][][] dp = new int[r][c][c];
        for (int i = r-1;i>=0;i--) {
            for (int j=c-1;j>=0;j--) { // alice
                for (int k = c-1;k>=0;k--) { // bob
                    if (i == grid.length - 1) {
                        if (j == k) dp[i][j][k] =  grid[i][j];
                        else dp[i][j][k] =  grid[i][j] + grid[i][k];
                        continue;
                    }


                    int max = Integer.MIN_VALUE;
                    int currentValue;

                    if (j == k) currentValue = grid[i][j];
                    else currentValue = grid[i][j] + grid[i][k];

                    for (int x = -1; x <= 1; x++) {
                        for (int y = -1; y <= 1; y++) {
                            // j -> alice, k -> bob
                            if (j + x < 0 || j + x == grid[0].length
                                    || k + y < 0 || k + y == grid[0].length) continue;
                            max = Math.max(max, dp[i + 1][ j + x] [k + y]);
                        }
                    }

                    dp[i][j][k] = max + currentValue;

                }
            }
        }

        return dp[0][0][c-1];
    }

    private static int recursiveApproach(int r, int c, int[][] grid) {
        int row = 0, aliceCol = 0, bobCol = c - 1;
        int[][][] dp = new int[r][c][c];
        return recursiveHelper(row, aliceCol, bobCol, grid, dp);
    }

    private static int recursiveHelper(int row, int aliceCol, int bobCol, int[][] grid, int[][][] dp) {
        // both of them will be at the same row
        if (row == grid.length - 1) {
            if (aliceCol == bobCol) return grid[row][aliceCol];
            return grid[row][aliceCol] + grid[row][bobCol];
        }

        if (dp[row][aliceCol][bobCol] != 0) return dp[row][aliceCol][bobCol];
        int max = Integer.MIN_VALUE;
        int currentValue;

        if (aliceCol == bobCol) currentValue = grid[row][aliceCol];
        else currentValue = grid[row][aliceCol] + grid[row][bobCol];

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (aliceCol + i < 0 || aliceCol + i == grid[0].length
                        || bobCol + j < 0 || bobCol + j == grid[0].length) continue;
                max = Math.max(max, recursiveHelper(row + 1, aliceCol + i, bobCol + j, grid, dp));
            }
        }

        return dp[row][aliceCol][bobCol] = max + currentValue;
    }
}
