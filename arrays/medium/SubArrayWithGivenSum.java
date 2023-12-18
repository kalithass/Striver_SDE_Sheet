package strivers.arrays.medium;

import strivers.App;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/submissions/
public class SubArrayWithGivenSum implements App {

    @Override
    public void run() {
        int[] nums = {5,5,6,3};
        int goal = 11;
        int res = numSubarraysWithSum(nums, goal);
        System.out.println(res);
    }

    public int subarraySum(int[] A, int S) {
        for(int element : A) {
            if(element < 0) {
                return numSubarraysWithSum(A, S);
            }
        }
        return helper(A, S) - helper(A, S - 1);
    }

    public int numSubarraysWithSum(int[] a, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int ele : a) {
            sum += ele;
            res += map.getOrDefault(sum-k, 0);
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return res;
    }

    private int helper(int[] nums, int limit) {
        int res = 0;
        int sum = 0;
        int len = nums.length;
        int start = 0;
        int end = 0;
        while (end < len) {
            sum += nums[end];
            end++;
            while (start < end && sum > limit) {
                sum -= nums[start];
                start++;
            }
            res += end - start + 1;
        }
        return res;
    }
}
