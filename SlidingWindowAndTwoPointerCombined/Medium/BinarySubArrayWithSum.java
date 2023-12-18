package strivers.SlidingWindowAndTwoPointerCombined.Medium;

import strivers.App;

//https://leetcode.com/problems/binary-subarrays-with-sum
public class BinarySubArrayWithSum implements App {

    @Override
    public void run() {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        int res = numSubarraysWithSum(nums, goal);
        System.out.println(res);
    }

    public int numSubarraysWithSum(int[] A, int S) {
        return helper(A, S) - helper(A, S - 1);
    }

    private int helper(int[] nums, int limit) {
        int res = 0;
        int sum = 0;
        int len = nums.length;
        int start = 0;
        int end = 0;
        while (end < len) {
            sum += nums[end];
            while (start <= end && sum > limit) {
                sum -= nums[start];
                start++;
            }
            res += end - start + 1;
            end++;
        }
        return res;
    }
}
