package strivers.dp.DP2d3d;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/ninja%E2%80%99s-training_3621003
public class NinjasTraining implements App {

    @Override
    public void run() {
        int[][] points = {
                {1, 2, 5},
                {3, 1, 1},
                {3, 3, 3}
        };
        int n = points.length;
        int res = ninjaTraining(n, points);
        System.out.println(res);
    }

    public static int ninjaTraining(int n, int points[][]) {
//        return recursiveHelper(n, points);
        return dpApproach(n, points);
    }

    private static int dpApproach(int n, int[][] points) {
        int[][] dp = new int[n+1][4];

        for (int i=n-1;i>=0;i--) {
            for (int prev=0;prev<=3;prev++) {

                int max = 0;
                for(int j=0;j<3;j++) {
                    if (j != prev) {
                        max = Math.max(points[i][j] + dp[i+1][j], max);
                    }
                }
                dp[i][prev] = max;
            }
        }
        return dp[0][3];
    }

    private static int recursiveHelper(int n, int[][] points) {
        int[][] dp = new int[n][4];
        for (int[] row: dp) Arrays.fill(row, -1);
        return recursiveApproach(0, points, 3, dp);
    }

    private static int recursiveApproach(int i, int[][] points, int prev, int[][] dp) {
        if (i == points.length) return 0;

        if (dp[i][prev] != -1) return dp[i][prev];
        int max = 0;
        for(int j=0;j<3;j++) {
            if (j != prev) {
                max = Math.max(points[i][j] + recursiveApproach(i+1, points, j, dp), max);
            }
        }
        return dp[i][prev] = max;
    }
}
