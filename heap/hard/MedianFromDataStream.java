package strivers.heap.hard;

import strivers.App;

import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/find-median-from-data-stream/
public class MedianFromDataStream implements App {

    @Override
    public void run() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        printArray(medianFinder);
        System.out.println(medianFinder.findMedian());
    }

    private void printArray(MedianFinder medianFinder) {
        System.out.println(medianFinder);
    }
}

class MedianFinder {

    PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> rightHeap = new PriorityQueue<>();


    public MedianFinder() {

    }

    public void addNum(int num) {
        // start by populating left heap
        leftHeap.add(num);

        // if size difference is > 1 (larger left) , remove value from left and populate to right
        if(leftHeap.size()-rightHeap.size() > 1) {
            rightHeap.add(leftHeap.poll());
        }

        // if there is greater value in left, remove value from left and populate to right
        if(!leftHeap.isEmpty() && !rightHeap.isEmpty() && leftHeap.peek() > rightHeap.peek()) {
            rightHeap.add(leftHeap.poll());
        }

        // if size difference is > 1 (larger right), remove value from right and populate to left
        if(rightHeap.size()-leftHeap.size() > 1) {
            leftHeap.add(rightHeap.poll());
        }
    }

    public double findMedian() {
        if (leftHeap.size() == rightHeap.size()) return (leftHeap.peek() + rightHeap.peek()) / 2.0;
        if (leftHeap.size() > rightHeap.size()) return leftHeap.peek();
        return rightHeap.peek();
    }
}