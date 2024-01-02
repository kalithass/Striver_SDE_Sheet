package strivers.dp.DP1d;


import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/house-robber/
public class HouseRobber implements App {

    @Override
    public void run() {
        int[] nums = {1, 2, 3, 1};
        int res = rob(nums);
        System.out.println(res);
    }

    public int rob(int[] nums) {
//        return recursiveApproach(nums);
        return dpApproach(nums);
    }

    private int dpApproach(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int a = nums[i], b = 0;
            if (i+2 < n) a = nums[i] + dp[i+2];
            if (i+1 < n) b = dp[i+1];
            dp[i] = Math.max(a, b);
        }
        return dp[0];
    }

    private int recursiveApproach(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return recursiveHelper(0, nums, dp);
    }

    private int recursiveHelper(int i, int[] nums, int[] dp) {
        if (i >= nums.length) return 0;
        // System.out.println(dp[i]+" "+i);
        if (dp[i] != -1) return dp[i];
        return dp[i] = Math.max(nums[i] + recursiveHelper(i + 2, nums, dp), recursiveHelper(i + 1, nums, dp));
    }
}
