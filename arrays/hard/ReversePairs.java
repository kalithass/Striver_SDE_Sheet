package strivers.arrays.hard;

import strivers.App;

//https://leetcode.com/problems/reverse-pairs/
public class ReversePairs implements App {

    @Override
    public void run() {
        int[] nums = {5,5,6,3};
        int res = reversePairs(nums);
        System.out.println(res);
    }

    public int reversePairs(int[] a) {
        return mergeSortModification(a, 0, a.length - 1);
    }

    private int mergeSortModification(int[] a, int low, int high) {
        int res = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            res += mergeSortModification(a, low, mid);
            res += mergeSortModification(a, mid + 1, high);
            res += findReversePairs(a, low, mid, high);
            merge(a, low, mid, high);
        }
        return res;
    }

    private int findReversePairs(int[] a, int low, int mid, int high) {
        int res = 0;
        int right = mid+1;
        for(int i=low;i<=mid;i++) {
            while(right<=high && a[i] > 2*(long)a[right])
            {
                right++;
            }
            res = res + (right-(mid+1));
        }
        return res;
    }

    void merge(int a[], int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int L1[] = new int[n1];
        int L2[] = new int[n2];
        for (int i = low; i <= mid; i++) {
            L1[i - low] = a[i];
        }
        for (int i = mid + 1; i <= high; i++) {
            L2[i - mid - 1] = a[i];
        }
        int i = 0, j = 0;
        int p = low;
        while (i < n1 && j < n2) {
            if (L1[i] <= L2[j]) {
                a[p++] = L1[i++];
            } else {
                a[p++] = L2[j++];
            }
        }
        while (i<n1) {
            a[p++] = L1[i++];
        }
        while (j<n2) {
            a[p++] = L2[j++];
        }
    }
}
