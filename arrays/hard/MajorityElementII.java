package strivers.arrays.hard;

import strivers.App;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/majority-element-ii/
public class MajorityElementII implements App {

    @Override
    public void run() {
        int[] nums = {3, 2, 3};
        List<Integer> res = majorityElement(nums);
        System.out.println(res);
    }

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int element1 = Integer.MIN_VALUE;
        int count1 = 0;

        int element2 = Integer.MIN_VALUE;
        int count2 = 0;


        for (int i = 0; i < nums.length; i++) {
            if (count1 == 0 && nums[i] != element2) {
                element1 = nums[i];
                count1++;
            } else if (count2 == 0 && nums[i] != element1) {
                element2 = nums[i];
                count2++;
            } else if (nums[i] == element2) count2++;
            else if (nums[i] == element1) count1++;
            else {
                count1--;
                count2--;
            }
        }
        int res1 = 0, res2 = 0;
        for (int element : nums) {
            if (element == element1) res1++;
            if (element == element2) res2++;
        }

        int base =  nums.length/3 ;
        if(res1 > base) res.add(element1);
        if(res2 > base) res.add(element2);
        return res;
    }
}
