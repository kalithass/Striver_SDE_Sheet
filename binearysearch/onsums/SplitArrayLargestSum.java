package strivers.binearysearch.onsums;

import strivers.App;

//https://leetcode.com/problems/split-array-largest-sum/
public class SplitArrayLargestSum implements App {

    @Override
    public void run() {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        int res = splitArray(nums, k);
        System.out.println(res);
    }

    public int splitArray(int[] nums, int k) {
//        return naiveApproach(nums, k);
        return optimalApproach(nums, k);
    }

    private int optimalApproach(int[] nums, int k) {
        int low = getMax(nums);
        int high = getSum(nums);
        while (low <= high) {
            int mid = (low + high) / 2;
            if(numberOfSplitSubArrays(nums, mid) > k) low = mid+1;
            else high = mid-1;
        }
        return low;
    }

    private int naiveApproach(int[] nums, int k) {
        int low = getMax(nums);
        int high = getSum(nums);
        for (int i = low; i <= high; i++) {
            if (numberOfSplitSubArrays(nums, i) == k) return i;
        }
        return low;
    }

    private int numberOfSplitSubArrays(int[] nums, int sum) {
        long subArraySum = 0;
        int splitArrays = 1;

        for (int element : nums) {
            if (subArraySum + element > sum) {
                splitArrays++;
                subArraySum = element;
            } else {
                subArraySum += element;
            }
        }

        return splitArrays;
    }


    private int getSum(int[] nums) {
        int res = 0;
        for (int element : nums) res += element;
        return res;
    }

    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int element : nums) max = Math.max(max, element);
        return max;
    }
}
