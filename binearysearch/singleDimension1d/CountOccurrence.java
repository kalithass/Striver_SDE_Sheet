package strivers.binearysearch.singleDimension1d;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/occurrence-of-x-in-a-sorted-array_630456
public class CountOccurrence implements App {

    @Override
    public void run() {
        int[] arr = {5,7,7,8,8,10};
        int res = count(arr, arr.length, 8);
        System.out.println(res);
    }


    public static int count(int[] a, int n, int target) {
        int start = findFirstPosition(a, n, target);
        if(start == -1) return 0;
        int end = findLastPosition(a, n, target);
        return end - start + 1;
    }

    private static int findLastPosition(int[] nums, int n, int target) {
        int low=0, high = n-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(nums[mid] <= target) low = mid+1;
            else high = mid-1;
        }
        if(high == -1 || high == n) return -1;
        return high;
    }

    private static int findFirstPosition(int[] nums, int n, int target) {
        int low=0, high = n-1;
        while (low<=high) {
            int mid = (low+high)/2;
            if(nums[mid] >= target) high = mid-1;
            else low = mid+1;
        }
        if(low == -1 || low == n) return -1;
        return low;
    }
}
