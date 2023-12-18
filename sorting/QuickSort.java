package strivers.sorting;

import strivers.App;

import java.util.Arrays;

//https://leetcode.com/problems/sort-an-array/description/
public class QuickSort implements App {

    @Override
    public void run() {
        int[] arr = {3, 2, 1, 5, 6, 4}; // 1 2 3 4 5 6
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    private void quickSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSortHelper(arr, low, p-1);
            quickSortHelper(arr, p+1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;
        while (i <= j) {
            while(i<=high && arr[i] <= pivot) i++;
            while(j>low && arr[j] > pivot) j--;
            if (i<=j) swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
