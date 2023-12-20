package strivers.arrays.easy;

import strivers.App;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

//https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_5713505
public class LongestSubArrayWithGivenSumKIncludingNegativeValues implements App {

    @Override
    public void run() {
        int[] arr = {1, -1, 1};
        int res = getLongestSubarray(arr, 1);
        System.out.println(res);
    }

    public static int getLongestSubarray(int []nums, int k) {
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;

        for(int i=0;i<nums.length;i++) {
            sum += nums[i];
            if(sum == k) maxLen = i+1;
            if(map.containsKey(sum-k)) {
                maxLen = Math.max(maxLen, i-map.get(sum-k));
            }
            if(!map.containsKey(sum)) map.put(sum, i);
        }
        return maxLen;
    }
}
