package strivers.heap.medium;

import strivers.App;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
public class KthLargestElementInArray implements App{

    @Override
    public void run() {
        int[] arr = {3,2,1,5,6,4}; // 1 2 3 4 5 6
        int k = 2;
        int res = findKthLargest(arr, k);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
    }

    public int findKthLargest(int[] nums, int k) {
//        return usingQueue(nums, k); // klogn
        return usingQuickSelect(nums, k);
    }

    private int usingQuickSelect(int[] arr, int k) {
        int left = 0, right = arr.length - 1, kth;
        while (true) {
            int idx = partition(arr, left, right);
            if (idx == k - 1) {
                kth = arr[idx];
                break;
            }
            if (idx < k - 1) {
                left = idx + 1;
            } else {
                right = idx - 1;
            }
        }
        return kth;
    }


    static int partition(int[] arr, int low, int high) {
        int pivot = arr[low] ;
        int l = low + 1 ;
        int r = high;
        while (l <= r) {
            if (arr[l] < pivot && arr[r] > pivot) {
                swap(arr, l, r);
                l++ ;
                r-- ;
            }
            if (arr[l] >= pivot) {
                l++;
            }
            if (arr[r] <= pivot) {
                r--;
            }
        }
        swap(arr, low, r);
        return r;
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    private static int usingQueue(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(e -> -e));
        for(int element : nums) pq.add(element);
        int res = Integer.MIN_VALUE;
        for(int i = 0; i< k; i++) {
            res = pq.poll();
        }
        return res;
    }
}
