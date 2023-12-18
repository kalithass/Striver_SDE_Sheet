package strivers.greedy.aryanPlaylist.medium;

import strivers.App;

import java.lang.reflect.Array;
import java.util.Arrays;

//https://leetcode.com/problems/count-the-number-of-beautiful-subarrays/
public class NumberOfBeautifulSubArrays implements App {

    @Override
    public void run() {
        int[] nums = {1, 2, 7, 5, 2, 10, 8, 9, 9, 4};
        long res = findMinimumTime(nums);
        System.out.println(res);
    }

    public long findMinimumTime(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1] ^ arr[i - 1];
        }

        System.out.println(Arrays.toString(arr));

        return 0;
    }
}
