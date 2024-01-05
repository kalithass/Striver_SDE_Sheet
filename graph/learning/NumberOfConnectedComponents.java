package strivers.graph.learning;

import strivers.App;

//https://www.codingninjas.com/studio/problems/find-the-number-of-states_1377943
public class NumberOfConnectedComponents implements App {

    @Override
    public void run() {
        int[][] roads = {   {1, 1, 0, 0},
                            {1, 1, 0, 0},
                            {0, 0, 1, 1},
                            {0, 0, 1, 1}};
        int res = findNumOfProvinces(roads, roads.length);
        System.out.println(res);
    }

    public static int findNumOfProvinces(int[][] roads, int n) {
        int[] visited = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                res++;
                dfs(roads, visited, i);
            }
        }
        return res;
    }

    private static void dfs(int[][] roads, int[] visited, int i) {
        visited[i] = 1;
        for (int j = 0; j < roads[i].length; j++) {
            if (visited[j] == 0 && roads[i][j] == 1) {
                dfs(roads, visited, j);
            }
        }
    }
}
