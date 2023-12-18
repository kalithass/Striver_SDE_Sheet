package strivers.graph.ShortestPathAlgosAndProblems;

import strivers.App;

import java.util.*;

//https://www.codingninjas.com/studio/problems/single-source-shortest-path_8416371
public class SingleSourceShortestPath implements App {

    @Override
    public void run() {
        int[][] edges = {{0, 1}, {1, 4}, {2, 3}, {2, 4}, {3, 4}};
        int N = 5;
        int[] res = shortestPath(N, edges, 1);
        System.out.println(Arrays.toString(res));
    }

    public static int[] shortestPath(int n, int[][] edges, int src) {
        List<List<Integer>> adjMatrix = getAdjMatrix(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        int[] res = new int[n];
        Arrays.fill(res, -1);
        res[src] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int element : adjMatrix.get(node)) {
                int newDistance = res[node] + 1;
                if (res[element] == -1 || res[element] > newDistance) {
                    res[element] = newDistance;
                    queue.add(element);
                }
            }
        }
        return res;
    }

    private static List<List<Integer>> getAdjMatrix(int n, int[][] edges) {
        List<List<Integer>> adjMatrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjMatrix.add(new ArrayList<>());
        }
        for (int[] pair : edges) {
            adjMatrix.get(pair[0]).add(pair[1]);
            adjMatrix.get(pair[1]).add(pair[0]);
        }
        return adjMatrix;
    }
}
