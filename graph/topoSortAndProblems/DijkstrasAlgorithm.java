package strivers.graph.topoSortAndProblems;

import strivers.App;

import java.util.*;

public class DijkstrasAlgorithm implements App {

    @Override
    public void run() {
        int[][] edges = {
                {0, 1, 2},
                {1, 2, 3},
                {2, 0, 1},
//                {2, 3, 2},
//                {2, 5, 5},
//                {4, 3, 2},
//                {3, 4, 5},
        };
        int n = 3;
        int m = 3;
        List<Integer> res = dijkstra(edges, n, m, 0);
        System.out.println(res);
    }



    // (V * get min) + (E * update key)
    // V logV + E logV -> here update key means adding new node to Queue
    public static List<Integer> dijkstra(int[][] edge,int vertices, int edges,int source){
        int n = vertices;
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++) res.add(-1);

        List<List<Pair>> adjMatrix = getAdjMatrixWithMap(edge, n);

        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        queue.add(new Pair(0, source));
        res.set(source, 0);
        while (!queue.isEmpty()) {
            Pair node = queue.poll(); // find min -> extract O(VlogV) [if it is queue it will be V]
            int nodeWeight = node.weight;
            int parent = node.node;

            // relaxing the edges O(E)
            for (Pair pair : adjMatrix.get(parent)) {
                int element = pair.node;
                int weight = pair.weight;
                int newDistance = nodeWeight + weight;
                if (res.get(element) == -1 || res.get(element) > newDistance) {
                    queue.add(new Pair(newDistance, element));
                    res.set(element,newDistance);
                }
            }
        }
        return res;
    }

    private static List<List<Pair>> getAdjMatrixWithMap(int[][] edges, int n) {
        List<List<Pair>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) adjList.add(new ArrayList<>());
        for (int[] pair : edges) {
            adjList.get(pair[0]).add(new Pair(pair[2], pair[1]));
            adjList.get(pair[1]).add(new Pair(pair[2], pair[0]));
        }
        return adjList;
    }

    static class Pair {
        int weight;
        int node;
        Pair(int w, int n) {
            weight = w;
            node = n;
        }
    }
}
