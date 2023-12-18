package strivers.graph.topoSortAndProblems;

import strivers.App;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class KhansAlgo implements App {
    @Override
    public void run() {
        int v = 2;
//        int[][] edges = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[][] edges = {{0, 1},{1,0}};
        boolean res= isCyclic(edges, 2, v);
        System.out.println(res);
    }

    public static Boolean isCyclic(int[][] edges, int v, int e)
    {
        List<List<Integer>> adjMatrix = getAdjMatrix(v, edges);
        List<Integer> res = new ArrayList<>();
        int[] degreeMatrix = new int[v];
        fillDegreesNodes(adjMatrix, degreeMatrix);
        populateResult(adjMatrix, degreeMatrix, res);
        return res.size() != v;
    }

    private static void populateResult(List<List<Integer>> adjMatrix, int[] degreeMatrix, List<Integer> res) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<degreeMatrix.length;i++) {
            if(degreeMatrix[i] == 0) {
                queue.add(i);
                res.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int val = queue.poll();
            for(int element : adjMatrix.get(val)) {
                degreeMatrix[element]--;
                if(degreeMatrix[element] == 0) {
                    res.add(element);
                    queue.add(element);
                }
            }
        }
    }

    private static void fillDegreesNodes(List<List<Integer>> adjMatrix, int[] degreeMatrix) {
        for(List<Integer> node : adjMatrix) {
            for(int element: node ) {
                degreeMatrix[element]++;
            }
        }
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
