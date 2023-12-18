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
        return usingBfs(graph);
    }

    private static boolean usingBfs(int[][] graph) {
        int n = graph.length;
        int[] colorMatrix = new int[n];
        for(int i=0;i<n;i++) {
            if(colorMatrix[i]==0 && !colorTheComponent(graph, i, colorMatrix)) return false;
        }
        return true;
    }

    private static boolean colorTheComponent(int[][] graph, int vertex, int[] colorMatrix) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{vertex,1});
        colorMatrix[vertex] = 1;
        while (!queue.isEmpty())  {
            int[] node = queue.poll();
            int i = node[0];
            int parentColor = node[1];
            for(int j = 0; j< graph[i].length; j++) {
                int element = graph[i][j];
                if(colorMatrix[element] !=0 && colorMatrix[element]!=parentColor) continue;
                if(colorMatrix[element] !=0 && colorMatrix[element]==parentColor) {
                    return false;
                } else {
                    int newColor = parentColor == 1 ? 2: 1;
                    colorMatrix[element] = newColor;
                    queue.add(new int[]{graph[i][j], newColor});
                }
            }
        }
        return true;
    }
}
