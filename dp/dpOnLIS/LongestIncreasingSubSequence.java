package strivers.dp.dpOnLIS;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubSequence implements App {

    @Override
    public void run() {
        int[] nums = {10,9,2,5,3,7,101,18};
        int res = lengthOfLIS(nums);
        System.out.println(res);
    }

    public int lengthOfLIS(int[] nums) {
//        return recursiveApproach(nums);
        return dpApproach(nums);
    }

    private int dpApproach(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = 1;
        for (int i=0;i<n;i++) {
            int ans = 1;
            for (int j=0;j<i;j++) {
                if(nums[i] > nums[j]) {
                    ans = Math.max(ans, 1 + dp[j]);
                    res = Math.max(res, ans);
                }
            }
            dp[i] = ans;
        }
        return res;
    }

    private int recursiveApproach(int[] nums) {
        max = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        recursiveHelper(nums.length-1, nums, dp);
        return max;
    }

    static int max = 1;

    private int recursiveHelper(int i, int[] nums, int[] dp) {
        if (i == 0)  return 1;

        if (dp[i] != -1) return dp[i];
        int ans = 1;
        for(int j=i-1;j>=0;j--) {
            if(nums[i] > nums[j]) {
                ans = Math.max(ans, 1 + recursiveHelper(j, nums, dp));
                max = Math.max(max, ans);
            }
        }
        recursiveHelper(i-1, nums, dp);
        return dp[i] =  ans;
    }
}
