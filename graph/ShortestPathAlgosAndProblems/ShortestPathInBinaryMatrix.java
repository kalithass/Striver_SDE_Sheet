package strivers.graph.ShortestPathAlgosAndProblems;

import strivers.App;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class ShortestPathInBinaryMatrix implements App {

    @Override
    public void run() {
        int[][] grid = {
                {1}
//                {1, 0, 0},
//                {1, 1, 0},
//                {1, 1, 0}
        };
        int res = shortestPathBinaryMatrix(grid);
        System.out.println(res);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n][n];
        for (int[] row : res) Arrays.fill(row, -1);
        int[] rowIncrement = {-1, -1, -1, 0,  0, 1, 1, 1};
        int[] colIncrement = {-1, 0, 1, -1,  1, -1, 0, 1};
        Queue<int[]> queue = new LinkedList<>();
        if(grid[0][0] == 0) {
            queue.add(new int[]{ 0, 0});
            res[0][0] = 1;
        }
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int row = arr[0];
            int col = arr[1];
            if(row == n-1 && col == n-1) return res[row][col];
            for (int i = 0; i < 8; i++) {
                int x = row + rowIncrement[i];
                int y = col + colIncrement[i];
                if (x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 0) {
                    int newDistance = 1+res[row][col];
                    if (res[x][y] == -1 || newDistance < res[x][y]) {
                        res[x][y] = newDistance;
                        queue.add(new int[]{ x, y});
                    }
                }
            }
        }
//        for(int[] row : res) System.out.println(Arrays.toString(row));
        return res[n-1][n-1];
    }
}
