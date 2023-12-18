package strivers.heap.hard;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-a-stream/
public class KthLargestElementInStream implements App {

    @Override
    public void run() {
        int[] nums = new int[]{4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(3, nums);

        System.out.println("=====================================");

        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}

class KthLargest {
    private PriorityQueue<Integer> heap = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int element : nums) add(element);
    }

    // heap will make sure to store top k elements
    // array is {1,5,4,7,2,8}
    // if k is 3,
    // 1 4 5
    // 1 4 5 7 (7 added) -> 4 5 7
    // 2 4 5 7 (2 added) -> 4 5 7
    // 4 5 7 8 (8 added) -> 5 7 8
    // so each time the smallest element in the heap is the kth largest element
    public int add(int val) {
        heap.offer(val);
        if (heap.size() > k) heap.poll();
        return heap.peek();
    }
}
