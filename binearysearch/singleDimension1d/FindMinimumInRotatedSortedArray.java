package strivers.binearysearch.singleDimension1d;

import strivers.App;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class FindMinimumInRotatedSortedArray implements App {

    @Override
    public void run() {
        int[] arr = {3, 5, 6, 0, 1, 3};
        int res = findMin(arr);
        System.out.println(res);
    }

    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(low<=high) {
            int mid = (low+high)/2;

            // left part is sorted
            if(nums[low]<=nums[mid]) {
                min = Math.min(min, nums[low]);
                low = mid+1;
            }
            else {
                min = Math.min(min, nums[mid]);
                high = mid-1;
            }
        }
        return min;
    }
}
