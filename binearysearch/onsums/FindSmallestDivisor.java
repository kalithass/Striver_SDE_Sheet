package strivers.binearysearch.onsums;

import strivers.App;

//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold
public class FindSmallestDivisor  implements App {

    @Override
    public void run() {
        int[] arr = {1,2,5,9};
        int threshold = 6;
        int res = smallestDivisor(arr, threshold);
        System.out.println(res);
    }

    // 1 -> 17
    // 4 -> 7
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = getMax(nums);
        while (low<=high) {
            int mid = (low+high)/2;
            int sum = getSum(nums, mid);
            if(sum > threshold) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    public int getSum(int[] nums, int mid) {
        int res = 0;
        for(int element : nums) {
            res += Math.ceil(element / (double)mid);
        }
        return res;
    }

    private int getMax(int[] bloomDay) {
        int max = Integer.MIN_VALUE;
        for (int element : bloomDay) max = Math.max(max, element);
        return max;
    }
}
