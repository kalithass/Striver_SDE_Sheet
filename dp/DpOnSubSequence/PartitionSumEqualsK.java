package strivers.dp.DpOnSubSequence;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/partition-equal-subset-sum/
public class PartitionSumEqualsK implements App {

    @Override
    public void run() {
        int[] nums = {1,5,11,5};
        boolean res = canPartition(nums);
        System.out.println(res);
    }

    // s1 = s2 and s1+s2 = sum of elements
    // so s1 = sum/2 , checking for s1 is enough, also odd sum is not possible
    // as adding two same numbers will always yield even number
    public boolean canPartition(int[] nums) {
        return recursiveApproach(nums);
    }

    private boolean recursiveApproach(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int element : nums) sum += element;

        if (sum %2 == 1) return false;
        int k = sum/2;
        int[][] dp = new int[n][k];
        for(int[] row : dp) Arrays.fill(row, -1);
        return recursiveHelper(0, 0, nums, k, dp);
    }

    private static boolean recursiveHelper(int i, int sum, int[] nums, int k, int[][] dp) {
        if (sum == k) return true;
        if (i == nums.length) return false;

        if (dp[i][sum] != -1) return dp[i][sum] == 0 ? false : true;
        if (sum + nums[i] <= k) {
            boolean res = recursiveHelper(i+1, sum+nums[i], nums, k, dp);
            dp[i][sum] = res ? 1 : 0;
            if (res) return true;
        }
        boolean res = recursiveHelper(i+1, sum, nums, k, dp);
        dp[i][sum] = res ? 1 : 0;
        return res;
    }
}
