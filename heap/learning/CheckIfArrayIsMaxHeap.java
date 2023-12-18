package strivers.heap.learning;

import strivers.App;

public class CheckIfArrayIsMaxHeap implements App {

    @Override
    public void run() {
        int[] arr = {1,3,4,1,2};
        boolean res = heapChecker(arr, 0, arr.length);
        System.out.println(res);
    }

    boolean heapChecker(int[] arr, int i, int n)
    {
        // Base case
        if (i >= (n - 1) / 2)
            return true;

        // If an internal node and is larger than its children,
        // and same is recursively true for the children
        return arr[i] >= arr[2 * i + 1] && arr[i] >= arr[2 * i + 2] &&
                heapChecker(arr, 2 * i + 1, n) && heapChecker(arr, 2 * i + 2, n);
    }
}
