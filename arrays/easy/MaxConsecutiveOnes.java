package strivers.arrays.easy;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/max-consecutive-ones/
public class MaxConsecutiveOnes  implements App {

    @Override
    public void run() {
        int[] arr = {3, 4, 5, 2};
        int res = findMaxConsecutiveOnes(arr);
        System.out.println(res);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 1) {
                count++;
                res = Math.max(res, count);
            } else count = 0;
        }
        res = Math.max(res, count);
        return res;
    }
}
