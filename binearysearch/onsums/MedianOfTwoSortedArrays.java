package strivers.binearysearch.onsums;

import strivers.App;

//https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays implements App {

    @Override
    public void run() {
        int[] nums1 = {};
        int[] nums2 = {1001};
        int k = 6;
        double res = findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        return naiveApproach(nums1, nums2);
        return optimalApproach(nums1, nums2);
    }

    private double optimalApproach(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) return usingBinarySearch(nums1, nums2);
        return usingBinarySearch(nums2, nums1);
    }


    private double usingBinarySearch(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1+n2;
        int length = (n1+n2)/2;

        // why high is n1 here
        // because we can even have the left array 0 elements
        // so n1 makes sure that INT_MIN will be assigned to left array part
        // ex: a = [], b = [1001]
        /*
                INT_MIN  INT_MAX
                INT_MIN  1001
         */
        int low = 0, high = n1;
        while (low<=high) {
            int mid1 = (low + high)/2;
            int mid2 = length - mid1;

            int l1 = Integer.MIN_VALUE, l2  = Integer.MIN_VALUE;;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;

            if(mid1>0) l1 = nums1[mid1-1];
            if(mid2 > 0) l2 = nums2[mid2-1];
            if(mid1 < n1) r1 = nums1[mid1];
            if(mid2 < n2) r2 = nums2[mid2];


            if(l1<=r2 && l2<=r1) {
                if(n%2 == 0) return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                return Math.min(r1,r2);
            }

            else if(l1 > r2) high = mid1-1;
            else low = mid1+1;
        }
        return -1;
    }

    private double naiveApproach(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n  = n1+n2;
        int mid = n/2;
        int midLeft = mid-1;

        int midElement = -1, midLeftElement = -1;
        int i = 0, j = 0, count = 0;
        while (i<n1 && j<n2) {
            if(nums1[i] < nums2[j]) {
                if (count == midLeft) midLeftElement = nums1[i];
                if(count == mid) midElement = nums1[i];
                i++;
            } else {
                if (count == midLeft) midLeftElement = nums2[j];
                if(count == mid) midElement = nums2[j];
                j++;
            }
            count++;
        }

        while (i<n1) {
            if (count == midLeft) midLeftElement = nums1[i];
            if(count == mid) midElement = nums1[i];
            i++;
            count++;
        }

        while (j<n2) {
            if (count == midLeft) midLeftElement = nums2[j];
            if(count == mid) midElement = nums2[j];
            j++;
            count++;
        }

        // System.out.println(midElement+" "+midLeftElement);
        if(n%2 == 1) return midElement;
        else return (midElement+midLeftElement) / 2.0;
    }
}
