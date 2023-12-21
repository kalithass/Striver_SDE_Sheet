package strivers.binearysearch.singleDimension1d;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastPositionInArray implements App {

    @Override
    public void run() {
        int[] arr = {5,7,7,8,8,10};
        int[] res = searchRange(arr, 8);
        System.out.println(Arrays.toString(res));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = findFirstPosition(nums, nums.length, target);
        res[1] = findLastPosition(nums, nums.length, target);
        return res;
    }

    private int findLastPosition(int[] nums, int n, int target) {
        int low=0, high = n-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(nums[mid] <= target) low = mid+1;
            else high = mid-1;
        }
        if(high==-1 || high==n || nums[high] != target) return -1;
        return high;
    }

    private int findFirstPosition(int[] nums, int n, int target) {
        int low=0, high = n-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(nums[mid] >= target) high = mid-1;
            else low = mid+1;
        }
        if(low==-1 || low==n || nums[low] != target) return -1;
        return low;
    }
}
