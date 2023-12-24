package strivers.arrays.medium;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/sort-colors/
public class SortArrayOf0sAnd1sAnd2s implements App {

    @Override
    public void run() {
        int[] arr = {1, 0, 0, 2, 1, 0, 0, 1};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int low =-1, high = n-1, mid = 0;
        while (mid<=high) {
            if(nums[mid] == 0) {
                low++;
                swap(nums, low, mid);
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

/*
        0 0 1 0 0
        0 0 0 0 1 1 1 1 1


 */