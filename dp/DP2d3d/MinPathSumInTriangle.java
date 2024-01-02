package strivers.dp.DP2d3d;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/triangle/
public class MinPathSumInTriangle implements App {

    @Override
    public void run() {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(2)));
        triangle.add(new ArrayList<>(List.of(3,4)));
        triangle.add(new ArrayList<>(List.of(6,5,7)));
        triangle.add(new ArrayList<>(List.of(4,1,8,3)));
        minimumTotal(triangle);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
//        return recursiveApproach(triangle);
//        return dpApproach(triangle);
        return spaceOptimizedApproach(triangle);
    }

    private int spaceOptimizedApproach(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n+1];

        for (int i=n;i>=0;i--) {
            int temp[] = new int[n+1];
            for (int j=i;j>=0;j--) {
                if (i == triangle.size() || j == triangle.get(i).size()) {
                    temp[j] = Integer.MAX_VALUE;
                    continue;
                }
                if (i == n-1) {
                    temp[j] = triangle.get(i).get(j);
                    continue;
                }
                int below = dp[j];
                int belowRight = dp[j+1];
                temp[j] = Math.min(belowRight, below) + triangle.get(i).get(j);
            }
            dp = temp;
        }
        return dp[0];
    }

    private int dpApproach(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n+1][n+1];

        for (int i=n;i>=0;i--) {
            for (int j=i;j>=0;j--) {
                if (i == triangle.size() || j == triangle.get(i).size()) {
                    dp[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                if (i == n-1) {
                    dp[i][j] = triangle.get(i).get(j);
                    continue;
                }
                int below = dp[i+1][j];
                int belowRight = dp[i+1][j+1];
                dp[i][j] = Math.min(belowRight, below) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    private int recursiveApproach(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return recursiveHelper(triangle, 0, 0, dp);
    }

    private int recursiveHelper(List<List<Integer>> list, int row, int col, int[][] dp) {
        if (row == list.size() || list.get(row).size() == col) return Integer.MAX_VALUE;
        if (row == list.size()-1) return list.get(row).get(col);
        if (dp[row][col] != -1) return dp[row][col];
        int below = recursiveHelper(list, row+1, col, dp);
        int belowRight = recursiveHelper(list, row+1, col+1, dp);
        return dp[row][col] = Math.min(belowRight, below) + list.get(row).get(col);
    }
}
