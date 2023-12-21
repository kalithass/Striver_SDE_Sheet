package strivers.binearysearch.singleDimension1d;

import strivers.App;

//https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
public class SearchInRotatedSortedArrayII implements App {

    @Override
    public void run() {
        int[] arr = {3, 5, 6, 6, 0, 1, 3};
        boolean res = search(arr, 0);
        System.out.println(res);
    }


    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return true;
            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

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
        return false;
    }
}
