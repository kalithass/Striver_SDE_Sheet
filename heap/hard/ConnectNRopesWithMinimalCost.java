package strivers.heap.hard;

import strivers.App;
import strivers.BinarySearchTrees.codestudio.TreeNode;

import java.util.PriorityQueue;

//https://www.codingninjas.com/studio/problems/connect-n-ropes-with-minimum-cost_625783
public class ConnectNRopesWithMinimalCost implements App {

    @Override
    public void run() {
        int[] arr = {4,3,2,6};
        int n = 4;

//        int[] arr = {4};
//        int n = 1;
        int res = minCost(arr, n);
        System.out.println(res);
    }

    static int minCost(int[] arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;

        for(int element : arr) pq.add(element);

        while (pq.size()>1) {
            int val = pq.poll() + pq.poll();
            res += val;
            pq.add(val);
        }

        return res;
    }
}
