package strivers.SlidingWindowAndTwoPointerCombined.Hard;

import strivers.App;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarrays-with-k-different-integers/
public class SubArraysWithKDistinctIntegers implements App {

    @Override
    public void run() {
        int[] arr = {1, 2, 1, 2, 3};
        int n = 2;
        int res = subarraysWithKDistinct(arr, n);
        System.out.println(res);
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

//    https://leetcode.com/problems/count-number-of-nice-subarrays/solutions/419378/java-c-python-sliding-window-o-1-space/
    private int atMost(int[] nums, int k) {
        int res = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (left <= right && map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                map.remove(nums[left], 0);
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }
}
