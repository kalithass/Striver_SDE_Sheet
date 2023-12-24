package strivers.binearysearch.onsums;

import strivers.App;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays implements App {

    @Override
    public void run() {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        int k = 6;
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }
}
