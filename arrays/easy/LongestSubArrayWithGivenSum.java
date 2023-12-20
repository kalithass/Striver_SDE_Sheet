package strivers.arrays.easy;

import strivers.App;

//https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399
public class LongestSubArrayWithGivenSum implements App {

    @Override
    public void run() {
        int[] arr = {1, 2, 3, 1, 1, 1};
        int res = longestSubarrayWithSumK(arr, 3);
        System.out.println(res);
    }

    public static int longestSubarrayWithSumK(int[] a, long k) {
        int left = 0, right = 0;
        int n = a.length;
        int maxLen = 0;
        int sum = 0;
        while (right < n) {
            sum += a[right];
            while (left<=right && sum > k) {
                sum -= a[left];
                left++;
            }
            if(sum == k && (right-left+1) > maxLen) maxLen = right-left+1;
            right++;
        }
        return maxLen;
    }
}
