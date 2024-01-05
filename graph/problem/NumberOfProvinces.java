package strivers.graph.problem;

import strivers.App;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/number-of-provinces/
public class NumberOfProvinces implements App {

    @Override
    public void run() {
        int[][] isConnected = {
                {1,1,0},
                {1,1,0},
                {0,0,1}
        };
        int res = findCircleNum(isConnected);
        System.out.println(res);
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int res = 0;
        for (int i=0;i<n;i++) {
            if (visited[i] == 0) {
                res++;
                bfs(visited, i, isConnected);
            }
        }
        return res;
    }

    private void bfs(int[] visited, int i, int[][] isConnected) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited[i] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int j=0;j<isConnected[node].length;j++) {
                int element = isConnected[node][j];
                if (visited[j] == 0 && element == 1) {
                    visited[j] = 1;
                    queue.add(j);
                }
            }
        }
    }
}
