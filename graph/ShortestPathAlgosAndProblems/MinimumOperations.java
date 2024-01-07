package strivers.graph.ShortestPathAlgosAndProblems;

import strivers.App;

import java.lang.reflect.Array;
import java.util.*;

//https://www.codingninjas.com/studio/problems/minimum-operations_8360665
public class MinimumOperations implements App {

    @Override
    public void run() {
        int n = 4;
        int start = 3;
        int end = 3;
        int[] a = {56, 43, 22, 11};
        int res = minimumOperations(n, start, end, a);
        System.out.println(res);
    }

    public static int minimumOperations(int n, int start, int end, int[] a) {
        if(start == end ) return 0;
        int mod = 1000;
        int[] distance = new int[1000];
        Queue<Pair> queue = new LinkedList<>();
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        queue.add(new Pair(0, start));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int element : a) {
                int val = (pair.val * element) % mod;
                if (pair.step+1 < distance[val]) {
                    queue.add(new Pair(pair.step + 1, val));
                    if(val == end) return pair.step+1;
                    distance[val] = pair.step+1;
                }
            }
        }
        return -1;
    }

    static class Pair {
        int step;
        int val;

        public Pair(int step, int val) {
            this.step = step;
            this.val = val;
        }
    }
}
