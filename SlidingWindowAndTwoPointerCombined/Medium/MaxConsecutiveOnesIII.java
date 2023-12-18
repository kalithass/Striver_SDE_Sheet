package strivers.SlidingWindowAndTwoPointerCombined.Medium;

import strivers.App;

//https://leetcode.com/problems/max-consecutive-ones-iii/
public class MaxConsecutiveOnesIII implements App {

    @Override
    public void run() {
        int[] arr = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        int res = longestOnes(arr, k);
        System.out.println(res);
    }

    public int longestOnes(int[] nums, int k) {
        int res = 0;
        int n = nums.length;
        int count = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            if(nums[right] == 0) count++;
            while (count > k) {
                if(nums[left] == 0) count--;
                left++;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}
