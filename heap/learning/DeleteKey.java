package strivers.heap.learning;

import java.util.ArrayList;
import java.util.List;

import strivers.App;

//https://www.codingninjas.com/studio/problems/implement-a-priority-queue-_1743878
public class DeleteKey implements App {
    @Override
    public void run() {
        List<Integer> heap = new ArrayList<>();
        push(heap, 3);
        push(heap, 2);
        push(heap, 7);
        push(heap, 5);
        push(heap, 6);
        push(heap, 1);
        System.out.println(heap);

        System.out.println(pop(heap));
        System.out.println(pop(heap));
        System.out.println(pop(heap));
        System.out.println(pop(heap));
    }

    public static int pop(List<Integer> heap) {
        if(heap.size() == 0) return -1;

        int res = heap.get(0);

        // bring last element to top
        int lastElement = heap.remove(heap.size()-1);
        if(heap.size()!=0) heap.set(0, lastElement);
        // else heap.add(lastElement);

        heapify(heap, 0);

        return res;
    }

    private static void heapify(List<Integer> heap, int i) {

        int largeInd = i;
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;

        // find large index among parent and children
        if(leftChild < heap.size() && heap.get(leftChild) > heap.get(largeInd)) {
            largeInd = leftChild;
        }
        if (rightChild < heap.size() && heap.get(rightChild) > heap.get(largeInd)) {
            largeInd = rightChild;
        }

        // if parent is not the greatest
        if(largeInd != i) {
            // swap parent with largest ind
            int largeValue = heap.get(largeInd);
            int indexValue = heap.get(i);
            heap.set(i, largeValue);
            heap.set(largeInd, indexValue);

            // continue heapify
            heapify(heap, largeInd);
        }
    }

    // Code Snippet of the push function:
     public static void push(List<Integer> heap, int x) {
             heap.add(x);

             // Position of the current inserted element.
             int pos = heap.size() - 1;

             // Shifting the element up until it reaches the topmost node if it is larger than its parent.
             while (pos > 0) {
                 int parent = (pos - 1) / 2;
                 if (heap.get(pos) > heap.get(parent)) {
                     // Swapping the elements.
                     int temp = heap.get(parent);
                     heap.set(parent, heap.get(pos));
                     heap.set(pos, temp);
                     pos = parent;
                 } else {
                     // As parent is larger, the element is now in its correct position.
                     break;
                 }
             }
         }
}