package strivers.graph.ShortestPathAlgosAndProblems;

import strivers.App;

import java.util.*;

//https://leetcode.com/problems/network-delay-time/
public class NetworkDelayTime implements App {

    @Override
    public void run() {
        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
//                {0, 1, 100},
//                {1, 2, 100},
//                {2, 0, 100},
//                {1, 3, 600},
//                {2, 3, 200}
        };
        int n = 4;
        int k = 2;
        int res = networkDelayTime(times, n, k);
        System.out.println(res);
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        n = n+1;
        List<List<int[]>> adjMatrix = getAdjMatrix(times, n);
        int[] res = new int[n];
        Arrays.fill(res, Integer.MAX_VALUE);
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.distance));
        res[k] = 0;
        queue.add(new Pair(k, res[k]));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            int distance = pair.distance;
            for(int[] arr : adjMatrix.get(node)) {
                int element = arr[0];
                int newDistance = distance + arr[1];
                if(newDistance < res[element]) {
                    res[element] = newDistance;
                    queue.add(new Pair(element, newDistance));
                }
            }
        }
        // System.out.println(Arrays.toString(res));
        int max = Integer.MIN_VALUE;
        for(int i=1;i<n;i++) {
            if(res[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, res[i]);
        }
        return max;
    }

    private List<List<int[]>> getAdjMatrix(int[][] times, int n) {
        List<List<int[]>> adjMatrix = new ArrayList<>();
        for (int i = 0; i < n; i++) adjMatrix.add(new ArrayList<>());
        for (int[] arr : times) {
            adjMatrix.get(arr[0]).add(new int[]{arr[1], arr[2]});
        }
        return adjMatrix;
    }

    static class Pair {
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
