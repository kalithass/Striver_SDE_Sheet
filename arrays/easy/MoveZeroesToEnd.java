package strivers.arrays.easy;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/move-zeroes/
public class MoveZeroesToEnd implements App {

    @Override
    public void run() {
        int[] arr = {0,1,0,3,12};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void moveZeroes(int[] nums) {
        int lastPositionOfZero = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i] != 0) {
                swap(nums, i, lastPositionOfZero);
                lastPositionOfZero++;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
