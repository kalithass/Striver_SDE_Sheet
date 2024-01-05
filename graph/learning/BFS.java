package strivers.graph.learning;

import strivers.App;

import java.util.*;

//https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1
public class BFS implements App {

    @Override
    public void run() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(1,2,3)));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(Arrays.asList(4)));
        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>());

        ArrayList<Integer> res = bfsOfGraph(adj.size(), adj);
        System.out.println(res);
    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        int[] visitedMatrix = new int[V];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visitedMatrix[0] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for (int element: adj.get(node)) {
                if (visitedMatrix[element] != 1) {
                    visitedMatrix[element] = 1;
                    queue.add(element);
                }
            }
        }
        return res;
    }
}
