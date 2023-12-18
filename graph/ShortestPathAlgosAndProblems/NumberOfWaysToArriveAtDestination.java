package strivers.graph.ShortestPathAlgosAndProblems;

import strivers.App;

import java.util.*;

//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
public class NumberOfWaysToArriveAtDestination implements App {

    @Override
    public void run() {
        int[][] edges = {
                {0, 6, 7},
                {0, 1, 2},
                {1, 2, 3},
                {1, 3, 3},
                {6, 3, 3},
                {3, 5, 1},
                {6, 5, 1},
                {2, 5, 1},
                {0, 4, 5},
                {4, 6, 2}};
        int n = 7;
        int res = countPaths(n, edges);
        System.out.println(res);
    }

    public int countPaths(int n, int[][] roads) {
        int mod = (int)(1e9 +7);
        List<List<int[]>> adjMatrix = getAdjMatrix(roads, n);
        int[] numberOfWays = new int[n];
        long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingLong(e -> e.distance));
        distance[0] = 0;
        numberOfWays[0] = 1;
        queue.add(new Pair(0, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int node = pair.node;
            long dist = pair.distance;
            for (int[] arr : adjMatrix.get(node)) {
                int element = arr[0];
                int weight = arr[1];
                long newDistance = dist + weight;
                if (newDistance < distance[element]) {
                    distance[element] = newDistance;
                    numberOfWays[element] = numberOfWays[node];
                    queue.add(new Pair(newDistance, element));
                } else if(newDistance == distance[element]) {
                    numberOfWays[element] = (numberOfWays[element] + numberOfWays[node]) % mod;
                }
            }
        }
        // System.out.println(Arrays.toString(numberOfWays));
        return numberOfWays[n-1];
    }

    private List<List<int[]>> getAdjMatrix(int[][] roads, int n) {
        List<List<int[]>> adjMat = new ArrayList<>();
        for (int i = 0; i < n; i++) adjMat.add(new ArrayList<>());
        for (int[] arr : roads) {
            adjMat.get(arr[0]).add(new int[]{arr[1], arr[2]});
            adjMat.get(arr[1]).add(new int[]{arr[0], arr[2]});
        }
        return adjMat;
    }

    static class Pair {
        long distance;
        int node;

        public Pair(long distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
}
