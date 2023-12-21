package strivers.arrays.hard;

import strivers.App;

//https://www.codingninjas.com/studio/problems/number-of-inversions_6840276
public class CountInversions implements App {

    @Override
    public void run() {
        int[] nums = {1,2,3,2};
        int res = numberOfInversions(nums, nums.length);
        System.out.println(res);
    }

    public static int numberOfInversions(int []a, int n) {
        // Write your code here.
        return mergeSort(a, 0, a.length - 1);
    }

    private static int mergeSort(int[] a, int low, int high) {
        int res = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            res += mergeSort(a, low, mid);
            res += mergeSort(a, mid + 1, high);
            res += merge(a, low, mid, high);
        }
        return res;
    }

    private static int merge(int[] a, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] L1 = new int[n1];
        int[] L2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            L1[i] = a[i + low];
        }
        for (int i = 0; i < n2; i++) {
            L2[i] = a[i + mid + 1];
        }
        int i=0,j=0;
        int p = low;
        int c = 0;
        while(i<n1 && j<n2) {
            if(L1[i] <= L2[j]) {
                a[p++] = L1[i++];
            }
            else {
                a[p++] = L2[j++];
                c += (n1-i);
            }
        }

        while(i<n1) {
            a[p++] = L1[i++];
        }
        while(j < n2) {
            a[p++] = L2[j++];
        }
        return c;
    }
}
