package strivers.stack.MonotonicProblems;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/count-of-greater-elements-to-the-right_8365436
public class NumberOfNGEsToRight implements App {

    @Override
    public void run() {
        int[] arr = {1, 3, 6, 5, 8, 9, 13, 4};
        int[] query = {0, 1, 5};
        int[] res = countGreater(arr, query);
        System.out.println(Arrays.toString(res));
    }

    public static int[] countGreater(int[] arr, int[] query) {
        int[] res = new int[arr.length];
        getResult(res, arr);
        int[] queryRes = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            queryRes[i] = res[query[i]];
        }
        return queryRes;
    }

    private static void getResult(int[] res, int[] arr) {
        int n = arr.length;
        int[][] pairArray = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairArray[i] = new int[]{arr[i], i};
        }
        mergeSort(res, pairArray, 0, n - 1);
    }

    private static void mergeSort(int[] res, int[][] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(res, arr, low, mid);
            mergeSort(res, arr, mid + 1, high);
            merge(res, arr, low, mid, high);
        }
    }

    private static void merge(int[] res, int[][] arr, int low, int mid, int high) {
        int[][] left = new int[mid - low + 1][2];
        int[][] right = new int[high - mid][2];

        int n1 = left.length, n2 = right.length;

        for (int i = 0; i < n1; i++) {
            left[i] = arr[low + i];
        }
        for (int i = 0; i < n2; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0;
        int p = low;

        while (i < n1 && j < n2) {
            if (left[i][0] < right[j][0]) {
                res[left[i][1]] += n2 - j;
                arr[p++] = left[i++];
            } else {
                arr[p++] = right[j++];
            }
        }

        while (i < n1) {
            arr[p++] = left[i++];
        }

        while (j < n2) {
            arr[p++] = right[j++];
        }
    }

    private static void print1(int[][] left) {
        for (int[] a : left) {
            System.out.print(Arrays.toString(a));
        }
        System.out.println();
    }
}

