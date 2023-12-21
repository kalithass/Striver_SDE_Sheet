package strivers.sorting.sortingii;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/sort-an-array/description/
public class MergeSort implements App {

    @Override
    public void run() {
        int[] arr = {3, 2, 1, 5, 6, 4}; // 1 2 3 4 5 6
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    private void mergeSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSortHelper(arr, low, mid);
            mergeSortHelper(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }

        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int p = low;

        while (i < n1 && j < n2) {
            if (left[i] < right[j]) {
                arr[p++] = left[i++];
            } else {
                arr[p++] = right[j++];
            }
        }

        while (i < n1) arr[p++] = left[i++];
        while (j < n2) arr[p++] = right[j++];
    }

    // 0 1 2 3 4
    // m = 2, n1 = m-low+1, n2 = high-mid



}
