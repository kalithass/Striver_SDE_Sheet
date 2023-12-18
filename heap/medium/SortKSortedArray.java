package strivers.heap.medium;

import strivers.App;

import java.util.ArrayList;
import java.util.PriorityQueue;

//https://practice.geeksforgeeks.org/problems/nearly-sorted-1587115620/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
public class SortKSortedArray implements App {

    @Override
    public void run() {
        int[] arr = {6,5,3,2,8,10,9};
        int k = 3;
        ArrayList<Integer> res = nearlySorted(arr, arr.length, k);
        System.out.println(res);
    }

    ArrayList <Integer> nearlySorted(int[] arr, int num, int k)
    {
        ArrayList<Integer> res = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<=k;i++) {
            pq.add(arr[i]);
        }


        for(int i=k+1;i<num;i++) {
            res.add(pq.poll());
            pq.add(arr[i]);
        }

        while (!pq.isEmpty()) res.add(pq.poll());
        return res;
    }

}
