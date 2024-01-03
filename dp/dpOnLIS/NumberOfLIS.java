package strivers.dp.dpOnLIS;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/number-of-longest-increasing-subsequence/
public class NumberOfLIS implements App {

    @Override
    public void run() {
        int[] arr = {1, 2, 4,3, 1};
        int n = arr.length;
        int res = findNumberOfLIS(arr);
        System.out.println(res);
    }

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        int max = 1;

        for (int i=0;i<n;i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j=i-1;j>=0;j--) {
                if (nums[i] >  nums[j]) {
                    // dp[i] = Math.max(dp[i], 1+dp[j]);
                    if (dp[i] == 1+dp[j]) count[i] += count[j];
                    else if (1+dp[j] > dp[i]) {
                        dp[i] = 1+dp[j];
                        count[i] = count[j];
                    }
                    max =  Math.max(max, dp[i]);
                }
            }
        }

        int res = 0;
        for (int i=0;i<n;i++) {
            if (dp[i] == max) res+=count[i];
        }
        return res;
    }
}
