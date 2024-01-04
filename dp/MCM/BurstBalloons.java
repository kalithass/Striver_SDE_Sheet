package strivers.dp.MCM;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/burst-balloons/
public class BurstBalloons implements App {

    @Override
    public void run() {
        int[] nums = {3,1,5,8};
        int res = maxCoins(nums);
        System.out.println(res);
    }

    public int maxCoins(int[] nums) {
        int[] arr = getExtendedArray(nums);
//        return recursiveApproach(arr);
        return dpApproach(arr);
    }

    private int dpApproach(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i=n-2;i>=1;i--) {
            for (int j=i;j<=n-2;j++) {
                int max = Integer.MIN_VALUE;
                for (int k=i;k<=j;k++) {
                    int curr = (nums[i-1] * nums[j+1] * nums[k]) +
                            dp[i][k-1] + dp[k+1][j];
                    max = Math.max(max, curr);
                }
                dp[i][j] = max;
            }
        }
        return dp[1][n-2];
    }

    private int recursiveApproach(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int[] row : dp) Arrays.fill(row, -1);
        return recursiveHelper(1, nums.length-2, nums, dp);
    }

    private int recursiveHelper(int i, int j, int[] nums, int[][] dp) {
        if (i>j) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int max = Integer.MIN_VALUE;
        for (int k=i;k<=j;k++) {
            int curr = (nums[i-1] * nums[j+1] * nums[k]) +
                    recursiveHelper(i, k-1, nums, dp) + recursiveHelper(k+1, j, nums, dp);
            max = Math.max(max, curr);
        }
        return dp[i][j] = max;
    }

    private int[] getExtendedArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+2];
        for (int i=0;i<n;i++) arr[i+1] = nums[i];
        arr[0] = 1;
        arr[n+1] = 1;
        return arr;
    }
}
