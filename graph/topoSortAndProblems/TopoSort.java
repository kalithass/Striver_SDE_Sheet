package strivers.graph.topoSortAndProblems;

import strivers.App;

import java.util.*;

//https://www.codingninjas.com/studio/problems/topological-sorting_973003
public class TopoSort  implements App {
    @Override
    public void run() {
        int v = 2;
//        int[][] edges = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] edges = {{0, 1},{1,0}};
        List<Integer> res = topologicalSort(edges, 2, v);
        System.out.println(res);
    }

    public static List<Integer> topologicalSort(int[][] edges, int e, int v) {
        // Write your code here!
        List<List<Integer>> adjMatrix = getAdjMatrix(v, edges);
        List<Integer> res = new LinkedList<>();
        int[] visited = new int[v];
        for(int i=0;i<v;i++) {
            if(visited[i] == 0) {
                topologicalSort(visited, res, i, adjMatrix);
            }
        }
        // if(res.size() != v) return false;
        // return true;
        Collections.reverse(res);
        return res;
        // if(res.size() != v) return new int[0];
        // return res.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void topologicalSort(int[] visited, List<Integer> res, int node, List<List<Integer>> adjMatrix) {
        visited[node] = 1;
        for(int element : adjMatrix.get(node)) {
            if(visited[element] == 0) {
                topologicalSort(visited, res, element, adjMatrix);
            }
        }
        res.add(node);
    }

    private static List<List<Integer>> getAdjMatrix(int numCourses, int[][] edges) {
        List<List<Integer>> adjMatrix = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjMatrix.add(new ArrayList<>());
        }

        for (int[] prerequisite : edges) {
            int from = prerequisite[0];
            int to = prerequisite[1];
            adjMatrix.get(from).add(to);
        }
        return adjMatrix;
    }
}
