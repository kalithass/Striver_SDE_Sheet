package strivers.graph.ShortestPathAlgosAndProblems;

import strivers.App;

import java.util.*;

//https://www.codingninjas.com/studio/problems/shortest-path-in-dag_8381897
public class ShortestPathInDAG implements App {

    @Override
    public void run() {
        int[][] edges = {
                {0, 1, 2},
                {1, 2, 3},
                {2, 1, 6}
        };
        int n = 3;
        int m = 3;
        int[] res = shortestPathInDAG(n, m, edges);
        System.out.println(Arrays.toString(res));
    }


    public static int[] shortestPathInDAG(int n, int m, int[][] edges) {
        List<Map<Integer, Integer>> adjMatrix = getAdjMatrixWithMap(edges, n);
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        res[0] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (Map.Entry<Integer, Integer> pair : adjMatrix.get(node).entrySet()) {
                int element = pair.getKey();
                int weight = pair.getValue();
                int newDistance = res[node] + weight;
                if (res[element] == -1 || res[element] > newDistance) {
                    queue.add(element);
                    res[element] = newDistance;
                }
            }
        }
        return res;
    }

    private static List<Map<Integer, Integer>> getAdjMatrixWithMap(int[][] edges, int n) {
        List<Map<Integer, Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new HashMap<>());
        for (int[] pair : edges) {
            adjList.get(pair[0]).put(pair[1], pair[2]);
        }
        return adjList;
    }
}
