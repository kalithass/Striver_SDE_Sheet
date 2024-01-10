package strivers.graph.problem;

import strivers.App;

import java.util.*;

//https://leetcode.com/problems/is-graph-bipartite/
public class BipartiteGraph implements App {
    @Override
    public void run() {
        int[][] mat = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        boolean res = isBipartite(mat);
        System.out.println(res);
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colorMatrix = new int[n];
        for (int i = 0; i < n; i++) {
            if (colorMatrix[i] == 0 && !colorTheComponentDFS(graph, i, colorMatrix, 1)) return false;
        }
        return true;
    }

    private static boolean colorTheComponentDFS(int[][] graph, int vertex, int[] colorMatrix, int color) {
        colorMatrix[vertex] = color;
        for (int i = 0; i < graph[vertex].length; i++) {
            int element = graph[vertex][i];
            int newColor = color == 1 ? 2 : 1;
            if (colorMatrix[element] == 0) {
                if (!colorTheComponentDFS(graph, element, colorMatrix, newColor)) return false;
            }
            else if(colorMatrix[element] == color) return false;
        }
        return true;
    }

    private static boolean colorTheComponentBFS(int[][] graph, int vertex, int[] colorMatrix) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        colorMatrix[vertex] = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int parentColor = colorMatrix[node];
            for (int j = 0; j < graph[node].length; j++) {
                int element = graph[node][j];
                if (colorMatrix[element] != 0 && colorMatrix[element] != parentColor) continue;
                if (colorMatrix[element] != 0 && colorMatrix[element] == parentColor) {
                    return false;
                } else {
                    int newColor = parentColor == 1 ? 2 : 1;
                    colorMatrix[element] = newColor;
                    queue.add(graph[node][j]);
                }
            }
        }
        return true;
    }
}
