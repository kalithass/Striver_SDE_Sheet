package strivers.graph.ShortestPathAlgosAndProblems;

import strivers.App;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/path-with-minimum-effort/
public class PathWithMinimumEffort implements App {

    @Override
    public void run() {
        int[][] heights = {
//                {1,10,6,7,9,10,4,9}
                {1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}
        };
        int res = minimumEffortPath(heights);
        System.out.println(res);
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e[2]));
        queue.add(new int[]{0, 0, 0});
        res[0][0] = 0;

        int[] rowIncrement = {-1, 1, 0, 0};
        int[] colIncrement = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int row = arr[0];
            int col = arr[1];
            if(row==n-1 && col==m-1) return res[row][col];
            for (int i = 0; i < 4; i++) {
                int x = row + rowIncrement[i];
                int y = col + colIncrement[i];
                if (x >= 0 && y >= 0 && x < n && y < m) {
                    int newEffort = Math.max(Math.abs(heights[row][col] - heights[x][y]), res[row][col]);
                    if(newEffort < res[x][y]) {
                        res[x][y] =newEffort;
                        queue.add(new int[]{x, y, res[x][y]});
                    }
                }
            }
        }
//        for(int[] row : res) System.out.println(Arrays.toString(row));
        return res[n-1][res[n-1].length-1];
    }
}
