package strivers.graph.MinimumSpanningTreeAndDisjointSets;

import strivers.App;

import java.util.*;

//https://www.codingninjas.com/studio/problems/minimum-spanning-tree_631769
public class PrimsAlgorithm implements App {

    @Override
    public void run() {

        int[][] mat = {
                {0, 1, 3},
                {0, 3, 5},
                {1, 2, 1},
                {2, 3, 8},
        };
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int[] ar : mat) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int element : ar) {
                list.add(element);
            }
            edges.add(list);
        }
        int n = 4;
        int res = minimumSpanningTree(edges, n);
        System.out.println(res);
    }

    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
        List<List<Pair>> adjList = getAdjList(edges, n);
        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int[] visited = new int[n];
        visited[0] = 1;
        int res = 0;
        queue.add(new Pair(0,0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if(visited[pair.node] == 0){
                visited[pair.node] = 1;
                res += pair.weight;
            }
            for(Pair p : adjList.get(pair.node)) {
                int element = p.node;
                int weight = p.weight;
                if(visited[element] == 1) continue;
                queue.add(new Pair(element, weight));
            }
        }
        return res;
    }

    private static List<List<Pair>> getAdjList(ArrayList<ArrayList<Integer>> edges, int n) {
        List<List<Pair>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) res.add(new ArrayList<>());
        for (List<Integer> list : edges) {
            int from = list.get(0);
            int to = list.get(1);
            int weight = list.get(2);
            res.get(from).add(new Pair(to, weight));
            res.get(to).add(new Pair(from, weight));
        }
//        System.out.println(res);
        return res;
    }

    static class Pair {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "[ "+node+", "+weight+" ]";
        }
    }
}
