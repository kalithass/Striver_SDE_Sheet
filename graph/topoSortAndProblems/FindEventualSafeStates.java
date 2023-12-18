package strivers.graph.topoSortAndProblems;

import strivers.App;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/find-eventual-safe-states/
public class FindEventualSafeStates implements App {
    @Override
    public void run() {
        int v = 2;
//        int[][] edges = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};

        List<Integer> res = eventualSafeNodes(graph);
        System.out.println(res);
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> res = new ArrayList<>();
        List<List<Integer>> adjMatrix = getAdjMatrix(graph);
        int[] visited = new int[n];
        int[] circleMatrix = new int[n];
        for(int i=0;i<n;i++) {
            if(visited[i] == 0) {
                dfsHelper(adjMatrix, i, visited, circleMatrix, res);
            }
        }
//        for(int v : extra) {
//            res.add(v);
//        }
        Collections.sort(res);
        return res;
    }

    private boolean dfsHelper(List<List<Integer>> adjMatrix, int node, int[] visited, int[] circleMatrix, List<Integer> res) {
        visited[node] = 1;
        circleMatrix[node] = 1;
        for(int element : adjMatrix.get(node)) {
            if(visited[element] == 0) {
                if(dfsHelper(adjMatrix, element, visited, circleMatrix, res)) return true;
            } else if(circleMatrix[element] == 1) return true;
        }
        circleMatrix[node] = 0;
        res.add(node);
        return false;
    }

    private List<List<Integer>> getAdjMatrix(int[][] graph) {
        List<List<Integer>> mat = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) mat.add(new ArrayList<>());
        for(int i =0;i<graph.length;i++) {
            for(int element : graph[i]) {
                mat.get(i).add(element);
            }
        }
        System.out.println(mat);
        return mat;
    }
}
