package strivers.heap.medium;

import strivers.App;

import java.util.*;

//https://www.codingninjas.com/studio/problems/merge-k-sorted-arrays_975379
public class KthSmallestElement implements App {

    @Override
    public void run() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(5);
        l1.add(9);
        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(45);
        l2.add(90);

        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(2);
        l3.add(6);
        l3.add(78);
        l3.add(100);
        l3.add(234);

        list.add(l1);
        list.add(l2);
        list.add(l3);

        List<Integer> res = mergeKSortedArrays(list, list.size());
        System.out.println(res);
    }

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
//        return usingPriorityQueue(kArrays, k);
        return usingRecursion(kArrays, kArrays.get(0), 1, k);
    }

    private static ArrayList<Integer> usingRecursion(ArrayList<ArrayList<Integer>> kArrays,ArrayList<Integer> list, int start, int end) {
        if (start == end) return list;
//        System.out.println(list+" "+kArrays.get(start));
        ArrayList<Integer> res = merge(list, kArrays.get(start));
//        System.out.println(res);
        return usingRecursion(kArrays, res, start+1, end);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            int a = l1.get(i);
            int b = l2.get(j);
            if (a < b) {
                res.add(a);
                i++;
            } else {
                res.add(b);
                j++;
            }
        }

        while (i<l1.size()) {
            res.add(l1.get(i));
            i++;
        }

        while (j<l2.size()) {
            res.add(l2.get(j));
            j++;
        }

        return res;
    }


    private static ArrayList<Integer> usingPriorityQueue(ArrayList<ArrayList<Integer>> kArrays, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        PriorityQueue<Container> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.val));
        for (int i = 0; i < k; i++) {
            pq.add(new Container(i, 0, kArrays.get(i).get(0)));
        }

        while (!pq.isEmpty()) {
            Container temp = pq.poll();
            res.add(temp.val);
            if (temp.col + 1 < kArrays.get(temp.row).size()) {
                int row = temp.row;
                int nextCol = temp.col + 1;
                int nextVal = kArrays.get(row).get(nextCol);
                pq.add(new Container(row, nextCol, nextVal));
            }
        }

        return res;
    }

    static class Container {
        int row;
        int col;
        int val;

        public Container(int row, int col, int val) {
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }
}
