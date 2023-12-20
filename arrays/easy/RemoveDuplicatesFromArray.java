package strivers.arrays.easy;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array
public class RemoveDuplicatesFromArray implements App {

    @Override
    public void run() {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }


    public int removeDuplicates(int[] nums) {
        int equalTillNow = 0;

        for(int i=0;i<nums.length;i++) {
            if(nums[equalTillNow] != nums[i]) {
                equalTillNow++;
                nums[equalTillNow] = nums[i];
            }
        }
        return equalTillNow+1;
    }
}
