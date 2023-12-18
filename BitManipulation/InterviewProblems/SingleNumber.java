package strivers.BitManipulation.InterviewProblems;

import strivers.App;

//https://leetcode.com/problems/single-number/
public class SingleNumber implements App {

    @Override
    public void run() {
        int[] nums = {4,1,2,1,2};
        int res = singleNumber(nums);
        System.out.println(res);
    }

    public int singleNumber(int[] nums) {
        int x = 0;
        for(int element : nums) {
            x ^= element;
        }
        return x;
    }
}
