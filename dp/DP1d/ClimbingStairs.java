package strivers.dp.DP1d;

import strivers.App;

//https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs implements App {

    @Override
    public void run() {
        int n = 2;
        int res = climbStairs(n);
        System.out.println(res);
    }

    public int climbStairs(int n) {
//        return recursiveApproach(n);
        return dpApproach(n);
    }

    private int dpApproach(int n) {
        int[] dp = new int[n+2];
        dp[n] = 1;

        for (int i=n-1;i>=0;i--) {
            dp[i] = dp[i+1] + dp[i+2];
        }
        return dp[0];
    }

    private int recursiveApproach(int n) {
        int[] dp = new int[n+1];
        return recursiveHelper( 0, n, dp);
    }

    private int recursiveHelper(int step, int n, int[] dp) {
        if (step > n) return 0;
        if (step == n) return 1;
        if (dp[step] != 0) return dp[step];
        return dp[step] = recursiveHelper(step+1, n, dp) + recursiveHelper(step+2, n, dp);
    }
}
