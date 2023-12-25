package strivers.binearysearch.onsums;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.codingninjas.com/studio/problems/k-th-element-of-2-sorted-array_1164159
public class KthElementOfTwoSortedArrays implements App {

    @Override
    public void run() {
        ArrayList<Integer> nums1 = new ArrayList<>(Arrays.asList(2, 3, 6, 7, 9));
        ArrayList<Integer> nums2 = new ArrayList<>(Arrays.asList(1, 4, 8, 10));
        int k = 4;
        int res = kthElement(nums1, nums2, nums1.size(), nums2.size(), k);
        System.out.println(res);
    }

    public static int kthElement(ArrayList<Integer> arr1, ArrayList<Integer> arr2, int n, int m, int k) {
//        return naiveApproach(arr1, arr2, k);
        return usingBinarySearch(arr1, arr2, k);
    }

    private static int optimalApproach(ArrayList<Integer> nums1, ArrayList<Integer> nums2, int k) {
        if (nums1.size() < nums2.size()) return usingBinarySearch(nums1, nums2, k);
        return usingBinarySearch(nums2, nums1, k);
    }


    private static int usingBinarySearch(List<Integer> nums1, List<Integer> nums2, int k) {
        int n1 = nums1.size();
        int n2 = nums2.size();

        int low = Math.max(0, k-n2), high = Math.min(n1, k);
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if (mid1 > 0) l1 = nums1.get(mid1 - 1);
            if (mid2 > 0) l2 = nums2.get(mid2 - 1);
            if (mid1 < n1) r1 = nums1.get(mid1);
            if (mid2 < n2) r2 = nums2.get(mid2);

            if(l1<=r2 && l2<=r1) return Math.max(l1,l2);
            else if(l1 > l2) high = mid1-1;
            else low = mid1+1;
        }
        return -1;
    }

    private static int naiveApproach(List<Integer> nums1, List<Integer> nums2, int k) {
        k--; // need 0 based indexing
        int n1 = nums1.size();
        int n2 = nums2.size();
        int kthElement = -1;
        int i = 0, j = 0, count = 0;
        while (i < n1 && j < n2) {
            if (nums1.get(i) < nums2.get(j)) {
                if (count == k) kthElement = nums1.get(i);
                i++;
            } else {
                if (count == k) kthElement = nums2.get(j);
                j++;
            }
            count++;
        }

        while (i < n1) {
            if (count == k) kthElement = nums1.get(i);
            i++;
            count++;
        }

        while (j < n2) {
            if (count == k) kthElement = nums2.get(j);
            j++;
            count++;
        }

        // System.out.println(kthElement+" "+midLeftElement);
        return kthElement;
    }
}
