package strivers.arrays.hard;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/
public class MergeTwoSortedArrays implements App {

    @Override
    public void run() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, nums1.length, nums2 , nums2.length);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j= n-1;
        int k = nums1.length-1;
        while (j>=0 && i>=0) {
            if(nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
            else nums1[k--] = nums2[j--];
        }

        // remaining elements in nums2
        while(j>=0) {
            nums1[k--] = nums2[j--];
        }
    }
}
