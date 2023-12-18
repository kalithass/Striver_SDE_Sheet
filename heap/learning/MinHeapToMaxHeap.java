package strivers.heap.learning;

import strivers.App;

import java.util.Arrays;

//https://www.codingninjas.com/studio/problems/convert-min-heap-to-max-heap_1381084
public class MinHeapToMaxHeap implements App {

    @Override
    public void run() {
        int[] arr = {3, 5, 6, 7, 9, 12, 7};
        int[] res = MinToMaxHeap(arr.length, arr);
        System.out.println(Arrays.toString(res));
    }

    public static int[] MinToMaxHeap(int n, int[] arr) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i);

        }
        return arr;
    }

    private static void heapify(int[] arr, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int max = i;
        if (left < arr.length && arr[left] > arr[max]) max = left;
        if (right < arr.length && arr[right] > arr[max]) max = right;
        if (i != max) {
            swap(arr, max, i);
            heapify(arr, max);
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
