package strivers.dp.DP1d;

import strivers.App;

//https://www.codingninjas.com/studio/problems/frog-jump_3621012
public class FrogJump implements App {

    @Override
    public void run() {
        int[] heights = {10, 20, 30, 10};
        int n = heights.length;
        int res = frogJump(n, heights);
        System.out.println(res);
    }

    public static int frogJump(int n, int heights[]) {
//        return recursiveApproach(n, heights);
        return dpApproach(n, heights);
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

    private static int recursiveApproach(int n, int[] heights) {
        int[] dp = new int[n];
        return recursiveHelper(0, heights, dp);
    }

    private static int recursiveHelper(int i, int[] heights, int[] dp) {
        if (i >= heights.length-1) return 0;
        if (dp[i] != 0) return dp[i];
        int a = Math.abs(heights[i + 1] - heights[i]) +recursiveHelper(i+1, heights, dp);
        int b = Integer.MAX_VALUE;
        if (i+2 < heights.length) {
            b = Math.abs(heights[i + 2] - heights[i]) +recursiveHelper(i+2, heights, dp);
        }
        return dp[i] = Math.min(a, b);
    }
}
