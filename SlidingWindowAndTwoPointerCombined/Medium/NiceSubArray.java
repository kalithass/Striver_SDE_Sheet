package strivers.SlidingWindowAndTwoPointerCombined.Medium;

import strivers.App;

//https://leetcode.com/problems/count-number-of-nice-subarrays/
public class NiceSubArray implements App {

    @Override
    public void run() {
        int[] arr = {1, 1, 2, 1, 1};
        int n = 3;
        int res = numberOfSubarrays(arr, n);
        System.out.println(res);
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private int atMost(int[] nums, int k) {
        int res = 0;
        int left = 0;
        int oddCount = 0;

        for (int right = 0; right < nums.length; right++) {
            oddCount += nums[right] % 2;
            while (left <= right && oddCount > k) {
                oddCount -= nums[left] % 2;
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
