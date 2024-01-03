package strivers.dp.dpOnLIS;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/largest-divisible-subset/
public class LongestDivisibleSubSet implements App {

    @Override
    public void run() {
        int[] nums = {4,8,10,240};
        List<Integer> res = largestDivisibleSubset(nums);
        System.out.println(res);
    }


    /*
            {1,5,8,4,16} -> after sorting {1,4,5,8,16}
            Longest divisible subset will be {1,4,8,16} we can return the list in any order
            Hence sorting and applying LIS approach will give res
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        return getLongestDivisibleSubset(nums);
    }

    private static List<Integer> getLongestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int max = 1;
        int maxi = 0;
        int[] dp = new int[n];
        int[] prev = new int[n];

        for (int i=0;i<n;i++) {
            int ans = 1;
            prev[i] = i;
            for (int j=i-1;j>=0;j--) {
                if (nums[i] % nums[j] == 0) {
                    // ans = Math.max(ans, 1 + dp[j]);
                    if (1+dp[j] > ans) {
                        ans = 1+dp[j];
                        prev[i] = j;
                    }
                    // max = Math.max(max, ans);
                    if (ans > max) {
                        maxi = i;
                        max = ans;
                    }
                }
            }
            dp[i] = ans;
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.toString(prev));

        List<Integer> res = new ArrayList<>();

        res.add(nums[maxi]);

        while (maxi != prev[maxi]) {
            maxi = prev[maxi];
            res.add(nums[maxi]);
        }

        return res;
    }
}
