package strivers.arrays.medium;

import strivers.App;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/
public class TwoSum implements App {

    @Override
    public void run() {
        int[] arr = {1, -1, 1};
        int[] res = twoSum(arr, 1);
        System.out.println(res);
    }


    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) res = new int[]{i, map.get(target - nums[i])} ;
            map.put(nums[i], i);
        }
        return res;
    }
}
