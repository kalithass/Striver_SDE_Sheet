package strivers.arrays.medium;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/majority-element/
public class MajorityElement implements App {

    @Override
    public void run() {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int res = majorityElement(arr);
        System.out.println(res);
    }


    public int majorityElement(int[] nums) {
        int count = 1;
        int num = nums[0];

        for(int i=1;i<nums.length;i++) {
            if(count == 0) {
                count++;
                num = nums[i];
            } else {
                if(nums[i] == num) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        return num;
    }
}
