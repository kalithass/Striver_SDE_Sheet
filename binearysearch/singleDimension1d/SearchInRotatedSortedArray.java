package strivers.binearysearch.singleDimension1d;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray implements App {

    @Override
    public void run() {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int res = search(arr, 0);
        System.out.println(res);
    }


    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            // either left or right portion is sorted

            // if left is sorted
            if(nums[low] <= nums[mid]) {
                
                if(nums[low]<=target && target<=nums[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }

            // right part is sorted
            else {
                if(nums[mid]<=target && target<=nums[high]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }
}
