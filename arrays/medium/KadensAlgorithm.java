package strivers.arrays.medium;

import strivers.App;

//https://leetcode.com/problems/maximum-subarray/
public class KadensAlgorithm implements App {

    @Override
    public void run() {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int res = maxSubArray(arr);
        System.out.println(res);
    }

    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for(int element : nums) {
            sum += element;
            res = Math.max(res, sum);
            if(sum < 0) sum = 0;
        }
        return res;
    }
}
