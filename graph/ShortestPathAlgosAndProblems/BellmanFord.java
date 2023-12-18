package strivers.graph.ShortestPathAlgosAndProblems;

import strivers.App;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BellmanFord implements App {

    @Override
    public void run() {
        int[][] mat = {
                {1, 2, 2},
                {1, 3, 2},
                {2, 3, -1},
        };
        List<List<Integer>> edges = new ArrayList<>();
        for(int[] arr : mat) {
            edges.add(Arrays.stream(arr)
                    .boxed()
                    .collect(Collectors.toList()));
        }
        int n = 3;
        int m = 3;
        int[] res = bellmonFord(n, m, 0, edges);
        System.out.println(Arrays.toString(res));
    }

    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        int[] res = new int[n+1];
        final int MAX_VALUE = (int)(1e+8);
        Arrays.fill(res, MAX_VALUE);
        res[src] = 0;
        for(int i=0;i<n-1;i++) {
            for(List<Integer> list : edges) {
                int node = list.get(0);
                int child = list.get(1);
                int weight = list.get(2);
                if(res[node] == MAX_VALUE) continue;
                int newDistance = weight + res[node];
                if(newDistance < res[child]) {
                    res[child] = newDistance;
                }
            }
        }
        return res;
    }
}
