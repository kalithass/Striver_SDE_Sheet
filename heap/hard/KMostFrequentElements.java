package strivers.heap.hard;

import strivers.App;

import javax.swing.*;
import java.util.*;

//https://leetcode.com/problems/top-k-frequent-elements/
public class KMostFrequentElements implements App {

    @Override
    public void run() {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] res = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(res));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for(int element : nums) {
            int val = map.getOrDefault(element, 0);
            map.put(element, val+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((p1,p2) -> p2.getValue()-p1.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) pq.add(entry);

        int[] res = new int[k];
        for(int i = 0;i<k;i++) {
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}