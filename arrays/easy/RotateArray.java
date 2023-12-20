package strivers.arrays.easy;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-array/
public class RotateArray implements App {

    @Override
    public void run() {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr, 3);
        System.out.println(Arrays.toString(arr));
    }

    /*
         1 2 3 4 5 6 7
         7 1 2 3 4 5 6 -> r1
         6 7 1 2 3 4 5 -> r2
         5 6 7 1 2 3 4 -> r3

         pattern ->
         1. reverse 0 to n-k-1
         2. reverse n-k to end
         3. reverse entire array
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        reverseNTimes(nums, 0, n-k-1);
        reverseNTimes(nums, n-k, n-1);
        reverseNTimes(nums, 0, n-1);
    }

    private void reverseNTimes(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
