package strivers.greedy.mediumAndHard;

import strivers.App;

//https://leetcode.com/problems/jump-game-ii/
public class JumpGameII implements App {

    @Override
    public void run() {
        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {2, 3, 0, 1, 4};
        int res = jump(nums);
        System.out.println(res);
    }

    public int jump(int[] nums) {
        return neetCodeApproach(nums);
//        return nikhilApproach(nums);
    }

    private int neetCodeApproach(int[] nums) {
        int l = 0, r = 0, res =0;
        int n = nums.length;
        while(r<n-1) {
            int currentFarthest = 0;
            for(int i=0;i<=r;i++) {
                currentFarthest = Math.max(currentFarthest , i+nums[i]);
            }
            res++;
            l++;
            r = currentFarthest;
        }
        return res;
    }

    private int nikhilApproach(int[] nums) {
        int l = 0, r = 0, farthest = 0;
        int res = 0;
        int n = nums.length;
        //    if(n == 1) return 0;
        for(int i=0;i<n-1;i++) {
            farthest = Math.max(farthest, i+nums[i]);
            if(i == r) {
                r = farthest;
                res++;

                //    if(farthest>=n-1) return res;
            }
        }

        return res;
    }
}
