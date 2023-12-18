package strivers.graph.OtherAlgorithms;

import strivers.App;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://www.codingninjas.com/studio/problems/articulation-point_840708
public class ArticulationPoint implements App {

    @Override
    public void run() {
        int t = 1;
        int n = 4;
        int m = 4;
        int[][] grid = {
                {1, 2},
                {1, 3},
                {2, 3},
                {3, 4}
        };
        Set<Integer> set = getArticulationPoints(grid, n+1, m);
        List<Set<Integer>> res = new ArrayList<>();
        res.add(set);
        printArticulationPoints(res);
    }

    private static Set<Integer> getArticulationPoints(int[][] grid, int n, int m) {
        List<List<Integer>> adjMatrix = getAdjList(n, grid);
        int[] visited = new int[n];
        Set<Integer> res = new HashSet<>();
        int[] timeOfInsertion = new int[n];
        int[] minTimeToReach = new int[n];
        int insertionTime = 1;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                // node parent result adjList visited timeOfInsertion minTimeToReach insertionTime
                findArticulationPoints(i, -1, res, adjMatrix, visited, timeOfInsertion, minTimeToReach, insertionTime, 0);
            }
        }
        return res;
    }

    private static void findArticulationPoints(int node, int parent, Set<Integer> res,
                                               List<List<Integer>> adjMatrix, int[] visited,
                                               int[] timeOfInsertion, int[] minTimeToReach, int insertionTime,
                                               int child) {
        visited[node] = 1;
        timeOfInsertion[node] = insertionTime;
        minTimeToReach[node] = insertionTime;
        for (int element : adjMatrix.get(node)) {
            if (element == parent) continue;
            if (visited[element] == 0) {
                findArticulationPoints(element, node, res, adjMatrix, visited,
                        timeOfInsertion, minTimeToReach, insertionTime+1, child);
                minTimeToReach[node] = Math.min(minTimeToReach[node], minTimeToReach[element]);
                if (minTimeToReach[element] >= timeOfInsertion[node] && parent != -1) {
                    res.add(node);
                }
                child++;
            } else {
                minTimeToReach[node] = Math.min(minTimeToReach[node], timeOfInsertion[element]);
            }
        }
        if (child > 1 && parent == -1) {
            res.add(node);
        }
    }

    private static List<List<Integer>> getAdjList(int n, int[][] grid) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) res.add(new ArrayList<>());
        for (int[] list : grid) {
            int u = list[0];
            int v = list[1];
            res.get(u).add(v);
            res.get(v).add(u);
        }
        return res;
    }

    private static void printArticulationPoints(List<Set<Integer>> res) {
        for (Set<Integer> set : res) {
            for (int element : set) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
