package strivers.arrays.easy;

import strivers.App;

import java.util.Arrays;

public class FindMissingNumberInArray implements App {

    @Override
    public void run() {
        int[] arr = {3,0,1};
        int res = missingNumber(arr);
        System.out.println(res);
    }

    public int missingNumber(int[] nums) {
        int res = 0;
        int n = nums.length;
        int sum = n;
        for(int i=0;i<n;i++) {
            res += nums[i];
            sum += i;
        }
        return sum - res;
    }
}
