package strivers.dp.DP1d;

import strivers.App;

public class FrogJumpKDistance implements App {

    @Override
    public void run() {
        int[] heights = {10, 40, 30, 10};
        int k = 2;
        int n = heights.length;
        int res = minimizeCost(n, k, heights);
        System.out.println(res);
    }

    public static int minimizeCost(int n, int k, int[] heights) {
        return recursiveApproach(n, k, heights);
//        return dpApproach(n, heights);
    }

    private static int dpApproach(int n, int[] heights) {
        int[] dp = new int[n];
        for (int i=n-2;i>=0;i--) {
            int a = Math.abs(heights[i + 1] - heights[i]) +dp[i+1];
            int b = Integer.MAX_VALUE;
            if (i+2 < heights.length) {
                b = Math.abs(heights[i + 2] - heights[i]) +dp[i+2];
            }
            dp[i] = Math.min(a, b);
        }
        return dp[0];
    }

    private static int recursiveApproach(int n, int k, int[] heights) {
        int[] dp = new int[n];
        return recursiveHelper(0, k, heights, dp);
    }

    private static int recursiveHelper(int i, int k, int[] heights, int[] dp) {
        if (i >= heights.length-1) return 0;

        if (dp[i] != 0) return dp[i];
        int max = Integer.MAX_VALUE;
        for (int j = 1;j<=k;j++) {
            if (i+j < heights.length) {
                int a = Math.abs(heights[i + j] - heights[i]) +recursiveHelper(i+j, k, heights, dp);
                max = Math.min(max, a);
            }
        }

        return dp[i] = max;
    }
}
