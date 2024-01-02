package strivers.dp.DP1d;

import strivers.App;
import strivers.Main;

//https://leetcode.com/problems/house-robber-ii/
public class HouseRobberII implements App {

    @Override
    public void run() {
        int[] nums = {2,3,2};
        int res = rob(nums);
        System.out.println(res);
    }

    public int rob(int[] nums) {
//        return recursiveApproach(nums);
        return dpApproach(nums);
    }

    // follow up of house robber 1
    private int dpApproach(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int removedLast = houseRobberDpApproach(nums, 0, n-1);
        int removedFirst = houseRobberDpApproach(nums, 1, n);
        return Math.max(removedLast, removedFirst);
    }

    private int houseRobberDpApproach(int[] nums, int start, int end) {
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = end - 1; i >= start; i--) {
            int a = nums[i], b = 0;
            if (i+2 < end) a = nums[i] + dp[i+2];
            if (i+1 < end) b = dp[i+1];
            dp[i] = Math.max(a, b);
        }
        return dp[start];
    }
}
