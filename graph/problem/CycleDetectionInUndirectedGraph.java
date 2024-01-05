package strivers.graph.problem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://www.codingninjas.com/studio/problems/detect-cycle-in-an-undirected-graph-_758967
public class CycleDetectionInUndirectedGraph {

    static class Graph {
        boolean detectCycle(int V, List<List<Integer>> adj) {
            int[] visitedMatrix = new int[V];

            for (int i = 0; i < V; i++) {
                if (visitedMatrix[i] == 0 && (detectCycleUsingDFS(adj, i, -1, visitedMatrix))) {
                    return true;
                }
            }
            return false;
        }

        private boolean detectCycleUsingDFS(List<List<Integer>> adj, int i, int parent, int[] visitedMatrix) {
            visitedMatrix[i] = 1;
            for (int adjElement : adj.get(i)) {
                if (visitedMatrix[adjElement] == 0) {
                    if (detectCycleUsingDFS(adj, adjElement, i, visitedMatrix)) return true;
                } else if (adjElement != parent) {
                    return true;
                }
            }
            return false;
        }

        private boolean detectCycleUsingBFS(List<List<Integer>> adj, int i, int[] visitedMatrix) {
            Queue<int[]> queue = new LinkedList<>();
            // node and parent
            queue.add(new int[]{i, -1});
            visitedMatrix[i] = 1;

            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                int node = temp[0];
                int parent = temp[1];
                for (int adjElement : adj.get(node)) {
                    if (visitedMatrix[adjElement] == 0) {
                        visitedMatrix[adjElement] = 1;
                        queue.add(new int[]{adjElement, node});
                    } else if (adjElement != parent ){ // connected adjElement is parent
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
