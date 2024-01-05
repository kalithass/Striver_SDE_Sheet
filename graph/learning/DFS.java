package strivers.graph.learning;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1
public class DFS implements App {

    @Override
    public void run() {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2,3,1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0,4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        ArrayList<Integer> res = dfsOfGraph(adj.size(), adj);
        System.out.println(res);
    }


    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        ArrayList<Integer> res = new ArrayList<>();
        dfs(visited, adj, 0, res);
        return res;
    }

    private void dfs(int[] visited, ArrayList<ArrayList<Integer>> adj, int i, ArrayList<Integer> res) {
        res.add(i);
        visited[i] = 1;
        for (int element : adj.get(i)) {
            if (visited[element] == 0) dfs(visited, adj, element, res);
        }
    }
}
