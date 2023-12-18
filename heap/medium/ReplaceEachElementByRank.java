package strivers.heap.medium;

import strivers.App;

import java.util.*;

//https://www.codingninjas.com/studio/problems/replace-each-element-of-array-with-its-corresponding-rank_975384
public class ReplaceEachElementByRank implements App {

    @Override
    public void run() {
        List<Integer> list = Arrays.asList(1, 2, 6, 9, 2);
        List<Integer> res = replaceWithRank(list, list.size());
        System.out.println(res);
    }

    public static List<Integer> replaceWithRank(List<Integer> arr, int n) {
//        return usingPriorityQueue(arr, n);
        return naiveApproach(arr, n);
    }

    private static List<Integer> naiveApproach(List<Integer> arr, int n) {
        List<Integer> res = new ArrayList<>();
        for (int element : arr) {
            Set<Integer> set = new HashSet<>();
            for(int j=0;j<n;j++) {
                if(arr.get(j) < element) set.add(arr.get(j));
            }
            res.add(set.size()+1);
        }
        return res;
    }

    private static List<Integer> usingPriorityQueue(List<Integer> arr, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(arr);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int i = 1; i <= n; i++) {
            int element = pq.poll();
            if (map.containsKey(element)) {
                continue;
            }
            map.put(element, rank++);
        }

        List<Integer> res = new ArrayList<>();
        for (int element : arr) {
            res.add(map.get(element));
        }

        return res;
    }
}
