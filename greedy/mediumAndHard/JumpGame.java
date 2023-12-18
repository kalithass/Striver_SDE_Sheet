package strivers.greedy.mediumAndHard;

import strivers.App;

//https://leetcode.com/problems/jump-game/
public class JumpGame implements App {

    @Override
    public void run() {
//        int[] nums = {2, 3, 1, 1, 4};
        int[] nums = {3, 2, 1, 0, 4};
        boolean res = canJump(nums);
        System.out.println(res);
    }

    public boolean canJump(int[] nums) {
//        return myApproach(nums);
        return neetCodeApproach(nums);
    }

    private boolean neetCodeApproach(int[] nums) {
        int n = nums.length;
        int goal = n-1;
        for(int i=n-2; i>=0;i--) {
            if(i+nums[i] >= goal) goal = i;
        }
        return goal == 0;
    }

    private static boolean myApproach(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        for (int i = 1; i < n; i++) {
            if(prev <= 0) return false;
            if(nums[i] >= prev) prev = nums[i];
            else prev--;
        }
        return true;
    }
}
